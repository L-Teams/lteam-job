package com.lteam.job.core.register;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorFrameworkFactory.Builder;
import org.apache.curator.retry.ExponentialBackoffRetry;

import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.server.ServerConfig;
import com.lteam.job.core.config.config.ConfigNode;
import com.lteam.job.core.config.server.ServersNode;

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
	
	private CuratorFramework cilent;
	
	
	public JobConfig getJobConfig() {
		return jobConfig;
	}

	public void setJobConfig(JobConfig jobConfig) {
		this.jobConfig = jobConfig;
	}

	public CuratorFramework getCilent() {
		return cilent;
	}

	public void setCilent(CuratorFramework cilent) {
		this.cilent = cilent;
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
     */
	public void registerServerConfigInfo() {
		 new ServersNode().addServerInfo(new ServerConfig()).storeServerInfo();
	}

	@Override
	public void registerSilenceJobConfigInfo() {
		
	}

	@Override
	public void registerMasterConfigInfo() {
		
	}

	@Override
	public void registerExecuterConfigInfo() {
	
	}

}
