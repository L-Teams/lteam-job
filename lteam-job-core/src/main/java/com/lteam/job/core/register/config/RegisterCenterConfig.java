package com.lteam.job.core.register.config;
/**
 * @Description:注册中心配置信息
 * @author guicheng.huang
 * @date: 2017年4月24日 上午11:25:26
 * @version V0.0.1
 */
public class RegisterCenterConfig {

	private String serversList;//注册中心服务地址
	
	private String nameSpace = "/lteam-job"; //默认命名空间为/lteam-job

    private int baseSleepTimeMilliseconds = 1000;
    
    private int maxSleepTimeMilliseconds = 3000;
    
    private int maxRetries = 3;  
    
    private int sessionTimeoutMilliseconds;
    
    private int connectionTimeoutMilliseconds;
    
    private String digest;
    
	public int getSessionTimeoutMilliseconds() {
		return sessionTimeoutMilliseconds;
	}

	public void setSessionTimeoutMilliseconds(int sessionTimeoutMilliseconds) {
		this.sessionTimeoutMilliseconds = sessionTimeoutMilliseconds;
	}

	public int getConnectionTimeoutMilliseconds() {
		return connectionTimeoutMilliseconds;
	}

	public void setConnectionTimeoutMilliseconds(int connectionTimeoutMilliseconds) {
		this.connectionTimeoutMilliseconds = connectionTimeoutMilliseconds;
	}

	public String getDigest() {
		return digest;
	}

	public void setDigest(String digest) {
		this.digest = digest;
	}

	public int getBaseSleepTimeMilliseconds() {
		return baseSleepTimeMilliseconds;
	}

	public void setBaseSleepTimeMilliseconds(int baseSleepTimeMilliseconds) {
		this.baseSleepTimeMilliseconds = baseSleepTimeMilliseconds;
	}

	public int getMaxSleepTimeMilliseconds() {
		return maxSleepTimeMilliseconds;
	}

	public void setMaxSleepTimeMilliseconds(int maxSleepTimeMilliseconds) {
		this.maxSleepTimeMilliseconds = maxSleepTimeMilliseconds;
	}

	public int getMaxRetries() {
		return maxRetries;
	}

	public void setMaxRetries(int maxRetries) {
		this.maxRetries = maxRetries;
	}

	public String getNameSpace() {
		return nameSpace;
	}

	public void setNameSpace(String nameSpace) {
		this.nameSpace = nameSpace;
	}

	public String getServersList() {
		return serversList;
	}

	public void setServersList(String serversList) {
		this.serversList = serversList;
	}
	
    
}
