package com.lteam.job.core.register;
/**
 * @Description:注册中心配置信息
 * @author guicheng.huang
 * @date: 2017年4月24日 上午11:25:26
 * @version V0.0.1
 */
public class RegisterCenterConfig {

	private String serversList;//注册中心服务地址
	
	private String nameSpace;

    private int baseSleepTimeMilliseconds = 1000;
    
    private int maxSleepTimeMilliseconds = 3000;
    
    private int maxRetries = 3;  
    
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
