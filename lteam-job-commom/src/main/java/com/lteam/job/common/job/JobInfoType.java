package com.lteam.job.common.job;
/**
 * @Description:job信息枚举
 * @author guicheng.huang
 * @date: 2017年4月26日 下午2:20:19
 * @version V0.0.1
 */
public enum JobInfoType {

	JOBCRON , //job正则
	JOBNAME , //job名称
	SILCENUM, //job分片数
	SILCESTARTEGY , //job分片策略
	SILCEEXECUTETYPE , //job分片任务执行类型
	EXECUTEORDER , //job执行顺序
	CHILDRENJOBNAME , //子任务名称
	JOBEXECUTERULE , //任务执行规则
	JOBDESCRIPTE , //任务描述
	JOBMASTER , //任务负责人
	MASTEREMAIL , // 负责人邮箱
	JOBSTATUS , //任务状态
	
	
}
