package com.lteam.job.common.version;

import com.lteam.job.common.job.JobConfig;

/**
 * @Description:job版本信息配置
 * @author guicheng.huang
 * @date: 2017年4月27日 下午2:04:45
 * @version V0.0.1
 */
public class VersionConfig {

	//zookeeper支持job信息存储最大数量
	private final Integer maxVersionNumber = 5;
	
	//版本号
	private int version;
	
	//job信息
	private JobConfig jobConfig;
	
	//版本状态
	private VersionStatus verStatus;
     
	public VersionConfig(){}
	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public JobConfig getJobConfig() {
		return jobConfig;
	}

	public void setJobConfig(JobConfig jobConfig) {
		this.jobConfig = jobConfig;
	}

	public VersionStatus getVerStatus() {
		return verStatus;
	}

	public void setVerStatus(VersionStatus verStatus) {
		this.verStatus = verStatus;
	}

	public Integer getMaxVersionNumber() {
		return maxVersionNumber;
	}
	
	
}
