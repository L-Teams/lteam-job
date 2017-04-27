package com.lteam.job.core.service.config;
import com.lteam.job.common.job.JobConfig;
/**
 * @Description:job 配置信息服务接口
 * @author guicheng.huang
 * @date: 2017年4月26日 下午3:07:22
 * @version V0.0.1
 */
public interface IJobConfigService {

	/**
	 * 功能:添加配置信息
	 * @param config
	 */
	public IJobConfigService addJobConfigInfo(JobConfig config);
	
	/**
	 * 功能:处理job配置信息
	 * 逻辑:1.新增job信息
	 *       如存在则比较job信息是否变更,如发生变更则修改
	 */
	public void handleJobInfo();
	
	/**
	 * 功能:销毁job信息
	 * 逻辑:1.判断该job是否正在执行,如果正在执行则阻塞直到当前任务执行完成
	 */
	public void destoryJobInfo();
	
	
}
