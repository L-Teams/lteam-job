package com.lteam.job.core.service.master;

import com.lteam.job.common.execute.ExecuteResult;
import com.lteam.job.common.job.JobStatus;
import com.lteam.job.core.config.master.MasterNode;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年4月26日 下午5:00:24
 * @version V0.0.1
 */
public interface IJobMasterService {
 
	/**
	 * 功能:添加配置信息
	 * @return
	 */
	public IJobMasterService addJobConfigInfo(MasterNode config);
	
	/**
	 * 功能:选主
	 * @return
	 */
	public MasterNode masterServer(); 
	
	/**
	 * 功能:获取主服务器信息
	 * @return String
	 */
	public String getMasterServiceInfo();
	
	/**
	 * 功能:获取job的运行结果
	 * @return ExecuteResult
	 */
	public ExecuteResult getJobExecuteResult();
	
	/**
	 * 功能:获取项目的执行状态
	 * @return JobStatus
	 */
	public JobStatus getJobExecuteStatus();
	
	
}
