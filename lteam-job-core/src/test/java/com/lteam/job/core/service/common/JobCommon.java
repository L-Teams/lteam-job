package com.lteam.job.core.service.common;

import com.lteam.job.common.job.JobConfig;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年5月10日 上午11:04:44
 * @version V0.0.1
 */
public class JobCommon {

	
	public static JobConfig getJobConfig(){
		JobConfig job = new JobConfig().builer("simpleJob", "1 0/30 * * * ?")
		        .addJobMaster("hgc")
		        .addMasterEmail("862896568@qq.com")
		        .addJobSliceStrategy("A=1;B=2;C=3")
		        .addJobSliceNum(3);
		job.setSystemName("lteam-job-example-spring");
		return job;
	}
}
