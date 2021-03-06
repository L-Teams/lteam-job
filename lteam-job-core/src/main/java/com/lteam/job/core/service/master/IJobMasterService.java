package com.lteam.job.core.service.master;
import com.lteam.job.common.config.Config;
import com.lteam.job.common.execute.ExecuteResult;
import com.lteam.job.core.config.master.MasterNode;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年4月26日 下午5:00:24
 * @version V0.0.1
 */
public interface IJobMasterService {
	
	/**
	 * 功能:添加主节点配置信息
	 * 逻辑:通过配置生成节点 , 注:service 基于node节点操作
	 * @param config
	 * @return
	 */
	public IJobMasterService addMasterConfigInfo(Config config);
	
	/**
	 * 功能:选主
	 * 逻辑:从服务器列表中选出主节点
	 * @return
	 */
	public MasterNode masterServer(); 
	
	/**
	 * 功能:获取主服务器信息
	 * 逻辑:查询出出节点信息
	 * @return String
	 */
	public String getMasterServiceInfo();
	
	/**
	 * 功能:获取job的运行结果
	 * 逻辑:任务分片的运行结果汇总到master,master将任务执行结果汇总到各个服务的执行结果中
	 * @return ExecuteResult
	 */
	public ExecuteResult getJobExecuteResult();
	
	/**
	 * 功能:获取项目的执行状态
	 * 逻辑:
	 * @return JobStatus
	 */
	public JobStatus getJobExecuteStatus();
	
	
}
