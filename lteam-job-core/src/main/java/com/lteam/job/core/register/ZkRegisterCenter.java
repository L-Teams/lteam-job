package com.lteam.job.core.register;
import org.apache.curator.RetryPolicy;
import org.apache.curator.RetrySleeper;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;

/**
 * @Description:基于zookeeper注册中心实现
 * @author guicheng.huang
 * @date: 2017年4月24日 上午11:10:41
 * @version V0.0.1
 */
public class ZkRegisterCenter extends RegisterCenter{

	//注册中心配置
	private RegisterCenterConfig centerConfig;
	
	private CuratorFramework cilent;
	
	public RegisterCenterConfig getCenterConfig() {
		return centerConfig;
	}

	public void setCenterConfig(RegisterCenterConfig centerConfig) {
		this.centerConfig = centerConfig;
	}

	public void inital() {
		cilent = CuratorFrameworkFactory.builder().connectString(centerConfig.getServersList())
		                                 .namespace(centerConfig.getNameSpace())
		                                 .retryPolicy(new ExponentialBackoffRetry(centerConfig.getBaseSleepTimeMilliseconds(), centerConfig.getMaxRetries(), centerConfig.getMaxSleepTimeMilliseconds()))
		                                 .build();
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

	@Override
	public void registerJobConfigInfo() {
		
		
	}

	@Override
	public void registerServerConfigInfo() {
		
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
