package com.lteam.job.core.service.config.impl;

import org.apache.curator.framework.CuratorFramework;

import com.lteam.job.common.job.JobConfig;
import com.lteam.job.core.config.config.ConfigNode;
import com.lteam.job.core.register.impl.ZkRegisterCenter;
import com.lteam.job.core.service.config.IJobConfigService;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年4月26日 下午3:11:54
 * @version V0.0.1
 */
public class ZkJobConfigServiceImpl implements IJobConfigService{

	private ConfigNode config;
	
	private static CuratorFramework cilent = null ; 
	
	static {
		if(cilent == null){
			cilent = ZkRegisterCenter.getCilent();
		}
	}
	
	public IJobConfigService addJobConfigInfo(ConfigNode config){
		this.config = config;
		return this;
	}
	
	public void handleJobInfo() {
		
	}

}
