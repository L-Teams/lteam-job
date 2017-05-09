package com.lteam.job.core.service.version.impl;
import java.util.ArrayList;
import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.jboss.netty.util.internal.StringUtil;
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

	private VersionNode versionNode;
	
	private static CuratorFramework cilent = null ; 
	
	private static IZookeeperCilentApi zkApi = new CuratorKeeperApiImpl();
	
	static {
		if(cilent == null){
			cilent = ZkRegisterCenter.getCilent();
		}
		zkApi.setCientObject(cilent);
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
			e.printStackTrace();
		}
		return result;
	}

	public VersionConfig getJobVersion(String version){
		String data = null;
		try {
			if(StringUtils.isEmpty(version)){
				return null;
			}
			//设置查询版本号
			versionNode.getVersionConfig().setVersion(version);
			data = zkApi.getNodeData(NodePath.getHistoryVersionPath(versionNode.getVersionConfig()));
		} catch (Exception e) {
			e.printStackTrace();
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
			e.printStackTrace();
		}
		return getJobVersion(version );
	}

	public VersionConfig getBestOldVersion() {
		
		return null;
	}
	
	public void handleVersionInfo() {
		try {
			String configPath = NodePath.getConfigPath(versionNode.getVersionConfig().getJobConfig());
			zkApi.addNodeListener(configPath, true, new VersionIterationListener());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IJobVersionService addVersionInfo(VersionNode versionNode) {
		this.versionNode = versionNode;
	    return this;
	}

	public void destoryBestOldVersionInfo(){
		VersionConfig versionConfig = getBestOldVersion();
		destoryVersionInfo(versionConfig.getVersion());
	}
	
	public void destoryVersionInfo(String version) {

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
			zkApi.createNode(new Node(versionNode.getVersionHistoryPath(), versionNode.getVersionHistoryContent()), CreateMode.PERSISTENT);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	

}
