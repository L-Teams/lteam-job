package com.lteam.job.core.config.master;

import com.lteam.job.common.config.Config;
import com.lteam.job.common.config.Node;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.config.NodeType;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.master.MasterConfig;
import com.lteam.job.common.util.GsonUtil;
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
	
	private String jobExecuteStatusPath;
	
	private String jobExecuteStatusContent;
	
	private String jobExecuteResult;
	
	private String jobExecuteResultContent;
	 
	public MasterNode(){
		nodeType = NodeType.MASTERNODE;
		nodeName = MasterNode.class.getSimpleName().toLowerCase();
	}
	
	public MasterNode(Config config){
		nodeType = NodeType.MASTERNODE;
		nodeName = MasterNode.class.getSimpleName().toLowerCase();
		nodePath = NodePath.getMasterNodePath(config);
		masterServerPath = NodePath.getMasterServerPath(config);
		routingStrategyPath = NodePath.getRoutingStrategyPath(config);
	    logServicePath = NodePath.getLogServicePath(config);
	}
	
	public MasterNode addMasterInfo(MasterConfig config){
		nodePath = NodePath.getMasterNodePath(config);
		masterServerPath = NodePath.getMasterServerPath(config);
		masterServerContent = config.getMasterHostName();
		routingStrategyPath = NodePath.getRoutingStrategyPath(config);
	    routingStrategyContent = config.getRouingType().toString(); //TODO->JSON
	    logServicePath = NodePath.getLogServicePath(config);
	    logServiceContent = config.getLogInterFace();//TODO->JSON
	    nodeContent = GsonUtil.gsonString(config);
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
	public void getMarsterServerInfo(){
		
	}
	
	/**
	 * 功能:获取节点的配置信息
	 * @return
	 */
	public MasterConfig getMasterInfo(){
		MasterConfig config = GsonUtil.gsonToBean(nodeContent, MasterConfig.class); 
		return config;
	}
}
