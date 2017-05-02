package com.lteam.job.core.config.config;
import com.lteam.job.common.config.Node;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.config.NodeType;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.util.GsonUtil;
import com.lteam.job.core.service.config.IJobConfigService;
import com.lteam.job.core.service.config.impl.ZkJobConfigServiceImpl;

/**
 * @Description:JOB 配置信息节点
 * @author guicheng.huang
 * @date: 2017年4月17日 上午9:55:15
 * @version V0.0.1
 */
public class ConfigNode extends Node{
	

	private IJobConfigService jobConfigService = new ZkJobConfigServiceImpl();
	
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
	 *     存在则更新confignode节点数据,更新的过程增加version,并获取version增加到版本节点,供还原任务版本使用->转移到单独的版本控制注册器
	 * @throws Exception 
	 */
	public void storeJobInfo() throws Exception{
		//job信息处理
		jobConfigService.addJobConfigInfo(getJobInfo())
		                .handleJobInfo();
	}
	
	/**
	 * 功能:回滚job
	 * 逻辑:
	 * @param version
	 */
	public void rollBackJobInfo(int version){
		
	}
	
	/**
	 * 功能:暂停job,如果当前job在执行,需保证当前job执行完在停止
	 * 逻辑:
	 */
	public void stopJob(){
		
	}
	
	/**
	 * 功能:启动job
	 * 逻辑:
	 */
	public void runJob(){
		
	}
	
	/**
	 * 功能:销毁job
	 * 逻辑:删除job节点
	 *    :需判断是否该job正在执行
	 *    :如果正在执行则阻塞删除操作，等待操作完成删除
	 */
	public void destoryJob(){
		jobConfigService.addJobConfigInfo(getJobInfo())
        				.destoryJobInfo();
	}
	
	/**
	 * 功能:获取job信息
	 * 逻辑:job 信息 json字符串->对象
	 */
	public JobConfig getJobInfo(){
		JobConfig config = GsonUtil.gsonToBean(nodeContent, JobConfig.class); 
		return config;
	}
}
