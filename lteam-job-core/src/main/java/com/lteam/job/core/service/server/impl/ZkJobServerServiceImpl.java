package com.lteam.job.core.service.server.impl;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;

import com.lteam.job.common.config.Node;
import com.lteam.job.common.server.ServerConfig;
import com.lteam.job.common.server.ServerStatus;
import com.lteam.job.common.util.GsonUtil;
import com.lteam.job.common.zkServer.IZookeeperCilentApi;
import com.lteam.job.common.zkServer.impl.CuratorKeeperApiImpl;
import com.lteam.job.core.config.server.ServersNode;
import com.lteam.job.core.register.impl.ZkRegisterCenter;
import com.lteam.job.core.service.server.IJobServerService;

/**
 * @Description:服务器服务类
 * @author guicheng.huang
 * @date: 2017年5月5日 下午6:14:17
 * @version V0.0.1
 */
public class ZkJobServerServiceImpl implements IJobServerService{

	private ServersNode serversNode ;
	
    private static CuratorFramework cilent = null ; 
	
	private static IZookeeperCilentApi zkApi = new CuratorKeeperApiImpl();
	
	static {
		if(cilent == null){
		   cilent = ZkRegisterCenter.getCilent();
		}
		zkApi.setCientObject(cilent);
	}
	
	public IJobServerService addServerInfo(ServerConfig config) {
		this.serversNode = new ServersNode().addServerInfo(config);
		return this;
	}

	//TODO -> Exception 自定义处理
	public void handleServerInfo() {
	    try {
			if(!zkApi.isExistPath(serversNode.getNodePath())){
				zkApi.createNode(serversNode.getNodePath(),CreateMode.PERSISTENT);
			}
			//处理服务器状态
			handleServerStatus();
			//处理服务器执行结果
			handleServerResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void handleServerStatus(){
		ServerStatus serverStatus = GsonUtil.gsonToBean(serversNode.getHostServerDate(), ServerStatus.class);
		ServerStatusCommand command = new ServerStatusCommand();
		command.setCommand(serverStatus);
		command.execute();
	}
	
	public void handleServerResult(){
		try {
			if(!zkApi.isExistPath(serversNode.getHostServerFailCoutPath())){
				zkApi.createNode(serversNode.getHostServerFailCoutPath(), serversNode.getHostServerFailCoutDate(), CreateMode.PERSISTENT);
			}
			if(!zkApi.isExistPath(serversNode.getHostServerSuccessCoutPath())){
				zkApi.createNode(serversNode.getHostServerSuccessCoutPath(), serversNode.getHostServerSuccessCoutDate(), CreateMode.PERSISTENT);
			}
			//TODO注册master任务结果监听,更新服务器执行结果
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void destoryServerInfo() {
		ServerStatusCommand command = new ServerStatusCommand();
		command.setCommand(ServerStatus.DESTORY);
		command.execute();
	}

	public void startServerInfo() {
		ServerStatusCommand command = new ServerStatusCommand();
		command.setCommand(ServerStatus.START);
		command.execute();
	}

	public void stopServerInfo() {
		ServerStatusCommand command = new ServerStatusCommand();
		command.setCommand(ServerStatus.STOP);
		command.execute();
	}

	public void readyServerInfo() {
		ServerStatusCommand command = new ServerStatusCommand();
		command.setCommand(ServerStatus.READY);
		command.execute();
	}
	
	
    //状态服务内部类
	class ServerStatusCommand{
	   
		Node node = null ; 
		
	    ServerStatus command = null ;
		
		public void setCommand(ServerStatus status){
			command = status;
			node = new Node(serversNode.getHostServerPath(), GsonUtil.gsonString(command));
		}
		
		public void execute(){
			try {
				if(command.equals(ServerStatus.DESTORY)){
					removeAction();
					return;
				}
				updateAction();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
		
		private void removeAction() throws Exception{
			if(zkApi.isExistPath(serversNode.getHostServerPath())){
			   zkApi.deleteNodeIncludeLeafNode(serversNode.getHostServerPath());
			}
		}
		
		private void updateAction() throws Exception{
		    if(!zkApi.isExistPath(serversNode.getHostServerPath())){
				zkApi.createNode(node);
			}else{
				if(!zkApi.versionComparison(node)){
					zkApi.updataNodeData(node);
				}
			}
		}
	}
   
}
