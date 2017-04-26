package com.lteam.job.core.config.config;
import org.apache.curator.framework.CuratorFramework;

import com.lteam.job.common.config.Node;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.config.NodeType;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.job.JobInfoType;
import com.lteam.job.common.job.JobStatus;
import com.lteam.job.common.util.GsonUtil;
import com.lteam.job.core.register.impl.ZkRegisterCenter;

/**
 * @Description:JOB 配置信息节点
 * @author guicheng.huang
 * @date: 2017年4月17日 上午9:55:15
 * @version V0.0.1
 */
public class ConfigNode extends Node{

	
	public ConfigNode(){
		nodeType = NodeType.CONFIGNODE;
		nodeName = ConfigNode.class.getSimpleName().toLowerCase();
	}
	
	public ConfigNode addJobInfo(JobConfig jobConfig){
		nodeContent = GsonUtil.gsonString(jobConfig);//to json
		nodePath = NodePath.getConfigPath(jobConfig);
		return this;
	}
	
	/**
	 * 功能:存储job config信息到zookeeper
	 * 逻辑:判断该job信息是否存在
	 *     不存在则新增
	 *     存在则更新confignode节点数据,更新的过程增加version,并获取version增加到版本节点,供还原任务版本使用
	 * @throws Exception 
	 */
	public void storeJobInfo() throws Exception{
		CuratorFramework cilent = ZkRegisterCenter.getCilent();
		if(cilent.checkExists().forPath(nodePath) != null){
			cilent.create().forPath(nodePath, nodeContent.getBytes());
		}else{
			cilent.setData().forPath(nodePath,nodeContent.getBytes());
		}
	}
	
	/**
	 * 功能:回滚job
	 * 逻辑:
	 * @param version
	 */
	private void rollBackJobInfo(int version){
		
	}
	
	/**
	 * 功能:暂停job,如果当前job在执行,需保证当前job执行完在停止
	 * 逻辑:
	 */
	private void stopJob(){
		
	}
	
	/**
	 * 功能:启动job
	 * 逻辑:
	 */
	private void runJob(){
		
	}
	
	/**
	 * 功能:销毁job
	 * 逻辑:
	 */
	private void destoryJob(){
		
	}
	
	/**
	 * 功能:获取job信息
	 * 逻辑:job 信息 json字符串->对象
	 */
	private JobConfig getJobInfo(){
		JobConfig config = GsonUtil.gsonToBean(nodeContent, JobConfig.class); 
		return config;
	}
}
