package com.lteam.job.common.version;

import java.util.Date;

import com.lteam.job.common.config.Config;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.version.factory.VersionNumFactory;

/**
 * @Description:job版本信息配置
 * @author guicheng.huang
 * @date: 2017年4月27日 下午2:04:45
 * @version V0.0.1
 */
public class VersionConfig extends Config{
	
	//版本号
	private String version = VersionNumFactory.creatVersionNum();
	
	//job信息
	private JobConfig jobConfig;
	
	//版本状态,默认当前应用版本
	private VersionStatus verStatus = VersionStatus.NOW;
     
	//版本创建日期
	private Date createDate = new Date();
	
	//版本修改日期,默认当前日期
	private Date updataDate = new Date();
	
	public VersionConfig(){}
	
	public VersionConfig addJobConfig(JobConfig jobConfig){
		super.systemName = jobConfig.getSystemName();
		super.jobName = jobConfig.getJobName();
		this.jobConfig = jobConfig;
		return this;
	}
	
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Date getUpdataDate() {
		return updataDate;
	}

	public void setUpdataDate(Date updataDate) {
		this.updataDate = updataDate;
	}
	
	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
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
	
	@Override
	public String toString() {
		return "VersionConfig [version=" + version + ", jobConfig=" + jobConfig
				+ ", verStatus=" + verStatus + ", createDate=" + createDate
				+ "]";
	}

}
