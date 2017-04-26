package com.lteam.job.core.service.config.impl;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;

import com.lteam.job.common.config.Config;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.core.config.config.ConfigNode;
import com.lteam.job.core.register.impl.ZkRegisterCenter;
import com.lteam.job.core.service.config.IJobConfigService;
import com.lteam.job.core.service.master.IJobMasterService;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年4月26日 下午3:11:54
 * @version V0.0.1
 */
public class ZkJobConfigServiceImpl implements IJobConfigService{

	private ConfigNode configNode;
	
	private static CuratorFramework cilent = null ; 
	
	@Autowired
	private IJobMasterService jobMasterService;
	
	static {
		if(cilent == null){
			cilent = ZkRegisterCenter.getCilent();
		}
	}
	
	public IJobConfigService addJobConfigInfo(JobConfig config){
		this.configNode = new ConfigNode().addJobInfo(config);
		return this;
	}
	
	//TODO -> Exception 自定义处理
	//     -> 版本信息处理
	public void handleJobInfo(){
		try {
			cilent.create()
			      .creatingParentsIfNeeded()
			      .forPath(configNode.getNodePath(), configNode.getNodeContent().getBytes());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destoryJobInfo(){
		try {
			Config c =new Config();
			jobMasterService.addJobConfigInfo(c);
			cilent.delete()
			      .deletingChildrenIfNeeded()
			      .forPath(NodePath.getJobPath(config.getJobInfo()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
