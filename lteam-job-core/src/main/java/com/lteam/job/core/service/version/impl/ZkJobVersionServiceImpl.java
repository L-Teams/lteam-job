package com.lteam.job.core.service.version.impl;

import java.util.List;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import org.springframework.beans.factory.annotation.Autowired;

import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.version.VersionConfig;
import com.lteam.job.common.zkServer.IZookeeperCilentApi;
import com.lteam.job.core.config.config.ConfigNode;
import com.lteam.job.core.config.version.VersionNode;
import com.lteam.job.core.register.impl.ZkRegisterCenter;
import com.lteam.job.core.service.version.IJobVersionService;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年4月27日 下午2:35:15
 * @version V0.0.1
 */
public class ZkJobVersionServiceImpl implements IJobVersionService {

	private VersionNode versionNode;
	
	private static CuratorFramework cilent = null ; 
	
	@Autowired
	private static IZookeeperCilentApi zkApi;
	
	static {
		if(cilent == null){
			cilent = ZkRegisterCenter.getCilent();
		}
		zkApi.setCientObject(cilent);
	}
	
	public List<VersionConfig> getJobVersionList() {
		// TODO Auto-generated method stub
		return null;
	}

	public VersionConfig getCurrentVersion() {
		// TODO Auto-generated method stub
		return null;
	}

	public void handleVersionInfo() {
		NodeCacheListener listener = new NodeCacheListener() {
			
			public void nodeChanged() throws Exception {
				
			}
		};
		zkApi.addNodeListener(NodePath.getConfigPath(versionNode), true, listener);
	}

	public void addVersionInfo(VersionConfig versionConfig) {
		versionNode = new VersionNode().addVersionInfo(versionConfig);
	}

	public void destoryVersionInfo(int version) {
		// TODO Auto-generated method stub

	}

}
