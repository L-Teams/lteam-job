package com.lteam.job.core.service.version.impl;
import java.util.List;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import com.lteam.job.common.version.VersionConfig;
import com.lteam.job.common.zkServer.IZookeeperCilentApi;
import com.lteam.job.core.config.version.VersionNode;
import com.lteam.job.core.listener.VersionIterationListener;
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
		return null;
	}

	public VersionConfig getCurrentVersion() {
		return null;
	}

	public void handleVersionInfo() {
		try {
			zkApi.addNodeListener(versionNode.getNodeContent(), true, new VersionIterationListener());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void addVersionInfo(VersionConfig versionConfig) {
		versionNode = new VersionNode().addVersionInfo(versionConfig);
	}

	public void destoryVersionInfo(int version) {

	}

}
