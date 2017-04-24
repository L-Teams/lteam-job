package com.lteam.job.core.config.server;

import com.lteam.job.common.config.Node;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.config.NodeType;
import com.lteam.job.common.server.ServerConfig;
import com.lteam.job.common.server.ServerInfoType;

/**
 * @Description:服务节点
 * @author guicheng.huang
 * @date: 2017年4月17日 上午9:57:50
 * @version V0.0.1
 */
public class ServersNode extends Node{

	//本机服务节点路径
	private String hostServerPath;
	
	//本机服务数据=服务器状态
	private String hostServerDate;
	
	//本机服务执行失败任务次数节点路径
	private String hostServerFailCoutPath;
	
	//本机服务执行成功任务次数节点路径
	private String hostServerSuccessCoutPath;
	
	public ServersNode(){
		nodeType = NodeType.SERVERNODE;
		nodeName = ServersNode.class.getSimpleName().toLowerCase();
	}
	
	public ServersNode addServerInfo(ServerConfig config){
		nodePath = NodePath.getServersPath(config);
		hostServerPath = NodePath.getServersPath(config)+"/"+config.getHostName();
		hostServerFailCoutPath = NodePath.getFailServerPath(config);
		hostServerSuccessCoutPath = NodePath.getSuccessServerPath(config);
		hostServerDate = config.getServerStatus().toString();
		return this;
	}
	
	/**
	 * 功能:存储服务器节点信息
	 * 逻辑:
	 */
	public void storeServerInfo(){
		
	}
	
	/**
	 * 功能:停止服务器
	 * 逻辑:
	 */
	private void stopServer(){
		
	}
	
	/**
	 * 功能:启动服务器
	 * 逻辑:
	 */
	private void runServer(){
		
	}
	
	/**
	 * 功能:销毁服务器
	 * 逻辑:
	 */
	private void destoryServer(){
		
	}
	
	/**
	 * 功能:获取服务器信息
	 * 逻辑:
	 */
	private void getServerInfo(ServerInfoType infoType){
		
	}
	
	/**
	 * 功能:获取主服务器信息
	 * 逻辑:
	 */
	private void getMasterInfo(){
		
	}
}
