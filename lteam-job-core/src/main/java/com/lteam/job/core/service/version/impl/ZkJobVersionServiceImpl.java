package com.lteam.job.core.service.version.impl;
import java.util.List;

import org.apache.curator.framework.CuratorFramework;

import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.version.VersionConfig;
import com.lteam.job.common.zkServer.IZookeeperCilentApi;
import com.lteam.job.common.zkServer.impl.CuratorKeeperApiImpl;
import com.lteam.job.core.config.version.VersionNode;
import com.lteam.job.core.listener.manager.node.impl.VersionIterationListener;
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
		return null;
	}

	public VersionConfig getCurrentVersion() {
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

	public void destoryVersionInfo(int version) {

	}

}
