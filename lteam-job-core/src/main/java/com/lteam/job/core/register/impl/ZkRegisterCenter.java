package com.lteam.job.core.register.impl;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorFrameworkFactory.Builder;
import org.apache.curator.retry.ExponentialBackoffRetry;

import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.master.MasterConfig;
import com.lteam.job.common.server.ServerConfig;
import com.lteam.job.core.config.config.ConfigNode;
import com.lteam.job.core.config.master.MasterNode;
import com.lteam.job.core.config.server.ServersNode;
import com.lteam.job.core.register.config.RegisterCenterConfig;

/**
 * @Description:基于zookeeper注册中心实现
 * @author guicheng.huang
 * @date: 2017年4月24日 上午11:10:41
 * @version V0.0.1
 */
public class ZkRegisterCenter extends RegisterCenter{

	//注册中心配置
	private RegisterCenterConfig centerConfig;
	
	//任务配置信息
	private JobConfig jobConfig;
	
	private static CuratorFramework cilent;
	
	
	public JobConfig getJobConfig() {
		return jobConfig;
	}

	public void setJobConfig(JobConfig jobConfig) {
		this.jobConfig = jobConfig;
	}

	public static CuratorFramework getCilent() {
		return cilent;
	}

	
	public RegisterCenterConfig getCenterConfig() {
		return centerConfig;
	}

	public void setCenterConfig(RegisterCenterConfig centerConfig) {
		this.centerConfig = centerConfig;
	}

	public void inital() {
		    Builder bulider = CuratorFrameworkFactory.builder().connectString(centerConfig.getServersList())
		                                 .namespace(centerConfig.getNameSpace())
		                                 .retryPolicy(new ExponentialBackoffRetry(centerConfig.getBaseSleepTimeMilliseconds(), centerConfig.getMaxRetries(), centerConfig.getMaxSleepTimeMilliseconds()));
		    if (0 != centerConfig.getSessionTimeoutMilliseconds()) {
		    	bulider.sessionTimeoutMs(centerConfig.getSessionTimeoutMilliseconds());
	        }
	        if (0 != centerConfig.getConnectionTimeoutMilliseconds()) {
	        	bulider.connectionTimeoutMs(centerConfig.getConnectionTimeoutMilliseconds());
	        }
	        cilent = bulider.build();
		    cilent.start();       
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void addRegisterInfo() {
		registerJobConfigInfo();
		registerServerConfigInfo();
		registerSilenceJobConfigInfo();
		registerSilenceJobConfigInfo();
		registerMasterConfigInfo();
		registerExecuterConfigInfo();
	}

	/**
	 * 功能:注册job信息
	 * 逻辑:
	 */
	public void registerJobConfigInfo() {
	     new ConfigNode().addJobInfo(jobConfig).storeJobInfo();
	}

    /**
     * 功能:注册服务器信息
     * 逻辑:
     */
	public void registerServerConfigInfo() {
		 new ServersNode().addServerInfo(new ServerConfig(jobConfig)).storeServerInfo();
	}

	/**
	 * 功能:注册任务分片信息
	 * 逻辑:
	 */
	public void registerSilenceJobConfigInfo() {
		
	}

	/**
	 * 功能:注册主节点信息
	 * 逻辑:
	 */
	public void registerMasterConfigInfo() {
		new MasterNode().addMasterInfo(new MasterConfig(jobConfig)).storeMasterServerInfo();
	}

	/**
	 * 功能:注册执行器信息
	 * 逻辑:
	 */
	public void registerExecuterConfigInfo() {
		//new ExecuteNode().addExecuteInfo(new ExecuteConfig(jobConfig)).
	}

}
