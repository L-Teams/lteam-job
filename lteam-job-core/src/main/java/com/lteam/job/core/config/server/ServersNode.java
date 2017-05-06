package com.lteam.job.core.config.server;
import com.lteam.job.common.config.Node;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.config.NodeType;
import com.lteam.job.common.server.ServerConfig;
import com.lteam.job.common.server.ServerInfoType;
import com.lteam.job.common.util.GsonUtil;
import com.lteam.job.core.service.server.IJobServerService;
import com.lteam.job.core.service.server.impl.ZkJobServerServiceImpl;

/**
 * @Description:服务节点
 * @author guicheng.huang
 * @date: 2017年4月17日 上午9:57:50
 * @version V0.0.1
 */
public class ServersNode extends Node{

    private IJobServerService jobServerService = new ZkJobServerServiceImpl();
	
	//本机服务节点路径
	private String hostServerPath;
	
	//本机服务数据=服务器状态
	private String hostServerDate;
	
	//本机服务执行失败任务次数节点路径
	private String hostServerFailCoutPath;
	
	//本机服务执行失败任务次数
	private String hostServerFailCoutDate;
	
	//本机服务执行成功任务次数节点路径
	private String hostServerSuccessCoutPath;
	
	//本机服务执行成功任务次数
	private String hostServerSuccessCoutDate;

	//服务器配置信息
	private ServerConfig config;
	
	public ServersNode(){
		nodeType = NodeType.SERVERNODE;
		nodeName = ServersNode.class.getSimpleName().toLowerCase();
	}
	
	public ServersNode addServerInfo(ServerConfig config){
		this.config = config;
		nodePath = NodePath.getServersPath(config);
		hostServerPath = NodePath.getServersPath(config)+"/"+config.getHostName();
		hostServerDate = GsonUtil.gsonString(config.getServerStatus());
		hostServerFailCoutPath = NodePath.getFailServerPath(config);
		hostServerFailCoutDate = GsonUtil.gsonString(config.getFailCount());
		hostServerSuccessCoutPath = NodePath.getSuccessServerPath(config);
		hostServerSuccessCoutDate = GsonUtil.gsonString(config.getSuccessCount());
		return this;
	}
	
	/**
	 * 功能:存储服务器节点信息
	 * 逻辑:
	 */
	public void storeServerInfo(){
		jobServerService.addServerInfo(getServerConfigInfo())
		                .handleServerInfo();
	}
	
	/**
	 * 功能:停止服务器
	 * 逻辑:
	 */
	public void stopServer(){
		jobServerService.addServerInfo(getServerConfigInfo())
		                .stopServerInfo();
	}
	
	/**
	 * 功能:启动服务器
	 * 逻辑:
	 */
	public void runServer(){
		jobServerService.addServerInfo(getServerConfigInfo())
        				.startServerInfo();
	}
	
	/**
	 * 功能:销毁服务器
	 * 逻辑:
	 */
	public void destoryServer(){
		jobServerService.addServerInfo(getServerConfigInfo())
						.destoryServerInfo();
	}
	
	/**
	 * 功能:获取服务器信息
	 * 逻辑:
	 */
	public void getServerInfo(ServerInfoType infoType){
		
	}
	
	/**
	 * 功能:获取主服务器信息
	 * 逻辑:
	 */
	public void getMasterInfo(){
		
	}
	
	/**
	 * 功能:获取服务器配置信息
	 * 逻辑:
	 * @return
	 */
	public ServerConfig getServerConfigInfo(){
		return this.config;
	}
	
	
	public IJobServerService getJobServerService() {
		return jobServerService;
	}

	public void setJobServerService(IJobServerService jobServerService) {
		this.jobServerService = jobServerService;
	}

	public String getHostServerPath() {
		return hostServerPath;
	}

	public void setHostServerPath(String hostServerPath) {
		this.hostServerPath = hostServerPath;
	}

	public String getHostServerDate() {
		return hostServerDate;
	}

	public void setHostServerDate(String hostServerDate) {
		this.hostServerDate = hostServerDate;
	}

	public String getHostServerFailCoutPath() {
		return hostServerFailCoutPath;
	}

	public void setHostServerFailCoutPath(String hostServerFailCoutPath) {
		this.hostServerFailCoutPath = hostServerFailCoutPath;
	}

	public String getHostServerSuccessCoutPath() {
		return hostServerSuccessCoutPath;
	}

	public void setHostServerSuccessCoutPath(String hostServerSuccessCoutPath) {
		this.hostServerSuccessCoutPath = hostServerSuccessCoutPath;
	}

	public ServerConfig getConfig() {
		return config;
	}

	public void setConfig(ServerConfig config) {
		this.config = config;
	}

	public String getHostServerFailCoutDate() {
		return hostServerFailCoutDate;
	}

	public void setHostServerFailCoutDate(String hostServerFailCoutDate) {
		this.hostServerFailCoutDate = hostServerFailCoutDate;
	}

	public String getHostServerSuccessCoutDate() {
		return hostServerSuccessCoutDate;
	}

	public void setHostServerSuccessCoutDate(String hostServerSuccessCoutDate) {
		this.hostServerSuccessCoutDate = hostServerSuccessCoutDate;
	}
}
