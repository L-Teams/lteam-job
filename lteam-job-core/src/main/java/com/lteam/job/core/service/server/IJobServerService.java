package com.lteam.job.core.service.server;

import com.lteam.job.common.server.ServerConfig;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年4月26日 下午3:08:34
 * @version V0.0.1
 */
public interface IJobServerService {

	/**
	 * 功能:添加服务器信息
	 * 逻辑:
	 * @param config
	 * @return
	 */
	public IJobServerService addServerInfo(ServerConfig config);
	
	/**
	 * 功能:处理服务器配置信息
	 * 逻辑:
	 */
	public void handleServerInfo();
	
	/**
	 * 功能:处理服务器状态
	 * 逻辑:
	 */
	public void handleServerStatus();
	
	/**
	 * 功能:处理服务器执行结果
	 * 逻辑:
	 */
	public void handleServerResult();
	
	/**
	 * 功能:销毁服务器信息
	 * 逻辑:
	 */
	public void destoryServerInfo();
	
	/**
	 * 功能:启动服务
	 * 逻辑:
	 */
	public void startServerInfo();
	
	/**
	 * 功能:暂停服务
	 * 逻辑:
	 */
	public void stopServerInfo();
	
	/**
	 * 功能:服务器重新等待状态
	 * 逻辑:
	 */
	public void readyServerInfo();
	
}
