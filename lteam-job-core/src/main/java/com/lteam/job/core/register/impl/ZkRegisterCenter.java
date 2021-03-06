package com.lteam.job.core.register.impl;
import org.apache.curator.framework.CuratorFramework;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.server.ServerConfig;
import com.lteam.job.common.zkServer.factory.CuratorFactory;
import com.lteam.job.common.zkServer.factory.config.RegisterCenterConfig;
import com.lteam.job.core.config.config.ConfigNode;
import com.lteam.job.core.config.server.ServersNode;
import com.lteam.job.core.config.version.VersionNode;

/**
 * @Description:基于zookeeper注册中心实现
 * @author guicheng.huang
 * @date: 2017年4月24日 上午11:10:41
 * @version V0.0.1
 */
public class ZkRegisterCenter extends RegisterCenter{

	private static final Logger logger = LoggerFactory.getLogger(ZkRegisterCenter.class);
	 
	//注册中心配置
	private static RegisterCenterConfig centerConfig;
	
	//任务配置信息
	private JobConfig jobConfig;
	
	//注册中心连接对象
	private static CuratorFramework cilent;
	
	public JobConfig getJobConfig() {
		return jobConfig;
	}

	public void setJobConfig(JobConfig jobConfig) {
		this.jobConfig = jobConfig;
	}

	public static void setCilent(CuratorFramework cilent) {
		ZkRegisterCenter.cilent = cilent;
	}
	
	public static CuratorFramework getCilent() {
		if(cilent == null){
			cilent = CuratorFactory.getCurator(centerConfig);
			cilent.start();
		}
		return cilent;
	}

	public static RegisterCenterConfig getCenterConfig() {
		return centerConfig;
	}

	public static void setCenterConfig(RegisterCenterConfig centerConfig) {
		ZkRegisterCenter.centerConfig = centerConfig;
	}

	/**
	 * 功能:
	 * 逻辑:初始化
	 */
	public void inital() {
		//获取连接对象
		cilent = getCilent();
		//注册信息
		addRegisterInfo();
	}

	public void close() {
		// TODO Auto-generated method stub
		
	}

	public void addRegisterInfo() {
		registerJobConfigInfo();
		registerServerConfigInfo();
		registerSilenceJobConfigInfo();
		registerMasterConfigInfo();
		registerExecuterConfigInfo();
		registerVersionConfigInfo();
	}

	/**
	 * 功能:注册job信息
	 * 逻辑:
	 */
	public void registerJobConfigInfo() {
	    try {
			new ConfigNode().addJobInfo(jobConfig).storeJobInfo();
			logger.info("register job config info");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

    /**
     * 功能:注册服务器信息
     * 逻辑:
     */
	public void registerServerConfigInfo() {
		try {
			new ServersNode().addServerInfo(new ServerConfig(jobConfig)).storeServerInfo();
			logger.info("register server info");
		} catch (Exception e) {
			e.printStackTrace();
		} 
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
	//	new MasterNode().addMasterInfo(new MasterConfig(jobConfig)).storeMasterServerInfo();
	}

	/**
	 * 功能:注册执行器信息
	 * 逻辑:
	 */
	public void registerExecuterConfigInfo() {
		
	}
	
	/**
	 * 功能:注册版本信息
	 * 逻辑:
	 */
	public void registerVersionConfigInfo(){
		new VersionNode().addVersionInfo(jobConfig).storeVersionInfo();
	}

}
