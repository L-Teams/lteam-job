package com.lteam.job.core.config.master;

import com.lteam.job.common.config.Node;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.config.NodeType;
import com.lteam.job.common.master.MasterConfig;
import com.lteam.job.core.config.server.ServersNode;

/**
 * @Description:主节点
 * @author guicheng.huang
 * @date: 2017年4月17日 上午9:57:08
 * @version V0.0.1
 */
public class MasterNode extends Node{

	private String masterServerPath;
	
	private String masterServerContent;
	
	private String routingStrategyPath;
	
	private String routingStrategyContent;
	
	private String logServicePath;
	
	private String logServiceContent;
	
	public MasterNode(){
		nodeType = NodeType.MASTERNODE;
		nodeName = MasterNode.class.getSimpleName().toLowerCase();
	}
	
	public MasterNode addMasterInfo(MasterConfig config){
		nodePath = NodePath.getMasterNodePath(config);
		masterServerPath = NodePath.getMasterServerPath(config);
		masterServerContent = config.getMasterHostName();
		routingStrategyPath = NodePath.getRoutingStrategyPath(config);
	    routingStrategyContent = config.getRouingType().toString(); //TODO->JSON
	    logServicePath = NodePath.getLogServicePath(config);
	    logServiceContent = config.getLogInterFace();//TODO->JSON
		return this;
	}
	
	/**
	 * 功能:存储主节点信息
	 * 逻辑
	 */
	public void storeMasterServerInfo(){
		
	}
	
	/**
	 * 功能:获取主节点信息
	 */
	private void getMarsterServerInfo(){
		
	}
}
