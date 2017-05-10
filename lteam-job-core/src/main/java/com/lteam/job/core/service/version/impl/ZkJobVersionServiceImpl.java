package com.lteam.job.core.service.version.impl;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.log4j.Logger;
import org.apache.zookeeper.CreateMode;
import org.springframework.util.StringUtils;

import com.lteam.job.common.config.Node;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.util.GsonUtil;
import com.lteam.job.common.version.VersionConfig;
import com.lteam.job.common.zkServer.IZookeeperCilentApi;
import com.lteam.job.common.zkServer.impl.CuratorKeeperApiImpl;
import com.lteam.job.core.config.version.VersionNode;
import com.lteam.job.core.listener.VersionIterationListener;
import com.lteam.job.core.register.impl.ZkRegisterCenter;
import com.lteam.job.core.service.version.IJobVersionService;

/**
 * @Description:版本信息处理服务类
 * @author guicheng.huang
 * @date: 2017年4月27日 下午2:35:15
 * @version V0.0.1
 */
public class ZkJobVersionServiceImpl implements IJobVersionService {

	private static final Logger logger =  Logger.getLogger(ZkJobVersionServiceImpl.class);
	
	private VersionNode versionNode;
	
	private static CuratorFramework cilent = null ; 
	
	private static IZookeeperCilentApi zkApi = new CuratorKeeperApiImpl();
	
	static {
		if(cilent == null){
			cilent = ZkRegisterCenter.getCilent();
		}
		zkApi.setCientObject(cilent);
	}
	
	public IJobVersionService addVersionInfo(VersionNode versionNode) {
		this.versionNode = versionNode;
	    return this;
	}

	public List<VersionConfig> getJobVersionList() {
		List<VersionConfig> result = null;
		try {
			result = new ArrayList<VersionConfig>();
			List<Node> nodeList = zkApi.getChildrenList(versionNode.getNodePath());
            for (Node node : nodeList) {
            	result.add(GsonUtil.gsonToBean(node.getNodeContent(), VersionConfig.class));
            }
		} catch (Exception e) {
			logger.error("lteam-job >> getJobVersionList exception error="+e);
		}
		return result;
	}

	public VersionConfig getJobVersion(String version){
		String data = null;
		try {
			if(StringUtils.isEmpty(version)){
				return null;
			}
			data = zkApi.getNodeData(versionNode.getNodePath()+"/"+version);
		} catch (Exception e) {
			logger.error("lteam-job >> getJobVersion exception param="+version+"   error="+e);
		}
		return GsonUtil.gsonToBean(data, VersionConfig.class);
	}
	
	public Integer getJobVersionNum() {
		return getJobVersionList()==null?0:getJobVersionList().size();
	}
	
	public VersionConfig getCurrentVersion() {
		String version = null ;
		try {
			version = zkApi.getNodeData(versionNode.getNodePath());
		} catch (Exception e) {
			logger.error("lteam-job >> getCurrentVersion exception error="+e);
		}
		return getJobVersion(version);
	}

	public void setCurrentVersion(String version){
		
	}

	public void updataVersion(VersionConfig config){
		
	}
	
	public void handleVersionInfo() {
		try {
			//处理初版信息
			storeVersionInfo();
			//添加监听
			zkApi.addNodeListener(NodePath.getConfigPath(versionNode.getVersionConfig().getJobConfig()), true, new VersionIterationListener());
		} catch (Exception e) {
			logger.error("lteam-job >> handleVersionInfo exception error="+e);
		}
	}
	
	public void destoryVersionInfo(String version) {
		try {
			VersionConfig currentVersion = getCurrentVersion();
			if(!currentVersion.getVersion().equals(version)){
				zkApi.deleteNodeIncludeLeafNode(versionNode.getNodePath()+"/"+version);
			}
		} catch (Exception e) {
			logger.error("lteam-job >> destoryVersionInfo exception param="+version+"  error="+e);
		}
	}

	public VersionConfig getBestOldVersion() {
		List<VersionConfig> versionList = getJobVersionList();
		Collections.sort(versionList, new Comparator<VersionConfig>() {

			@Override
			public int compare(VersionConfig o1, VersionConfig o2) {
				if(o1.getUpdataDate() != null && o2.getUpdataDate() != null){
					if(o1.getUpdataDate().compareTo(o2.getUpdataDate())<=0){
						return 1;
					}
				}
				return 0;
			}
		});
		return versionList!=null?versionList.get(0):null;
	}
	
	public void destoryBestOldVersionInfo(){
		destoryVersionInfo(getBestOldVersion().getVersion());
	}
	
	public void storeVersionInfo() {
		try {
		    //处理最新版本内容
			if(!zkApi.isExistPath(versionNode.getNodePath())){
				zkApi.createNode(versionNode);
			}
			zkApi.updataNodeData(versionNode);
			//处理版本列表容量
			if( getJobVersionNum() >= versionNode.getVersionConfig().getJobConfig().getMaxVersionNumber()){
				destoryBestOldVersionInfo();
			}
			//更新版本列表
			versionNode.getVersionConfig().setCreateDate(new Date());
			zkApi.createNode(new Node(versionNode.getVersionHistoryPath(), versionNode.getVersionHistoryContent()), CreateMode.PERSISTENT);
		} catch (Exception e) {
			logger.error("lteam-job >> storeVersionInfo exception error="+e);
		}
	}
}
