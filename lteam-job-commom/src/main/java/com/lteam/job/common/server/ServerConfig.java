package com.lteam.job.common.server;

import com.lteam.job.common.config.Config;

/**
 * @Description:服务器配置信息
 * @author guicheng.huang
 * @date: 2017年4月18日 下午5:47:15
 * @version V0.0.1
 */
public class ServerConfig extends Config{

	private String hostIp = ""; //提供静态方法获取本机ip;
	
	private String post = ""; //提供静态方法获取本机服务的端口;
	
	private ServerStatus serverStatus = ServerStatus.START; //服务器状态,默认直接可运行job,可以设置READY,等所有服务器上线统一运行job

	private int failCount = 0; //任务失败的数量,用于统计该服务器执行任务的失败率,判断服务器是否可靠;
	
	private int successCount = 0;//任务成功的数量;
	
	public ServerConfig(Config config){
		super(config);
	}
	
	public String getHostName(){
		String hostName = hostIp+":"+post;//问题?可能为处理post  ->TODO
		return hostName;
	}
	
	public int getFailCount() {
		return failCount;
	}

	public void setFailCount(int failCount) {
		this.failCount = failCount;
	}

	public int getSuccessCount() {
		return successCount;
	}

	public void setSuccessCount(int successCount) {
		this.successCount = successCount;
	}

	public String getHostIp() {
		return hostIp;
	}

	public void setHostIp(String hostIp) {
		this.hostIp = hostIp;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public ServerStatus getServerStatus() {
		return serverStatus;
	}

	public void setServerStatus(ServerStatus serverStatus) {
		this.serverStatus = serverStatus;
	}
			
}
