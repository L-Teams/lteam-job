package com.lteam.job.common.job;

import com.lteam.job.common.config.Config;

/**
 * @Description:job配置信息
 * @author guicheng.huang
 * @date: 2017年4月18日 下午4:59:49
 * @version V0.0.1
 */
public class JobConfig extends Config{

	private String jobCron;
	
	private String jobDescripte;
	
	private String jobMaster;
	
	private String masterEmail;
	
	private int jobSliceNum;
	
	private String jobSliceStrategy;
	
	private String childrenJobName;
	
	private String executeRule;
	
	private JobStatus jonStatus = JobStatus.RUN;
	
	//zookeeper支持job信息存储最大数量
	private final Integer maxVersionNumber = 5;
		
	public Integer getMaxVersionNumber() {
		return maxVersionNumber;
	}

	public JobConfig(){}
	
	public JobConfig(String jobName, String jobCron){
		this.jobName = jobName;
		this.jobCron = jobCron;
	}
	
	public JobConfig builer(String jobName, String jobCron){
		this.jobName = jobName;
		this.jobCron = jobCron;
		return this;
	}

	public JobConfig addJobStatus(JobStatus jobStatus){
		this.setJonStatus(jonStatus);
		return this;
	}
	
	public JobConfig addJobDescripte(String jobDescripte){
		this.setJobDescripte(jobDescripte);
		return this;
	}

	public JobConfig addJobMaster(String jobMaster){
		this.setJobMaster(jobMaster);
		return this;
	}
	
	public JobConfig addMasterEmail(String masterEmail){
		this.setMasterEmail(masterEmail);
		return this;
	}
	
	public JobConfig addJobSliceNum(int jobSliceNum){
		this.setJobSliceNum(jobSliceNum);
		return this;
	}
	
	public JobConfig addJobSliceStrategy(String jobSliceStrategy){
		this.setJobSliceStrategy(jobSliceStrategy);
		return this;
	}
	public JobConfig addChildrenJobName(String childrenJobName){
		this.setChildrenJobName(childrenJobName);
		return this;
	}
	
	public JobConfig addExecuteRule(String executeRule){
		this.setExecuteRule(executeRule);
		return this;
	}
	
	
	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

	public String getJobCron() {
		return jobCron;
	}

	public void setJobCron(String jobCron) {
		this.jobCron = jobCron;
	}

	public JobStatus getJonStatus() {
		return jonStatus;
	}

	public void setJonStatus(JobStatus jonStatus) {
		this.jonStatus = jonStatus;
	}
	
	public String getJobDescripte() {
		return jobDescripte;
	}

	public void setJobDescripte(String jobDescripte) {
		this.jobDescripte = jobDescripte;
	}

	public String getJobMaster() {
		return jobMaster;
	}

	public void setJobMaster(String jobMaster) {
		this.jobMaster = jobMaster;
	}

	public String getMasterEmail() {
		return masterEmail;
	}

	public void setMasterEmail(String masterEmail) {
		this.masterEmail = masterEmail;
	}

	public int getJobSliceNum() {
		return jobSliceNum;
	}

	public void setJobSliceNum(int jobSliceNum) {
		this.jobSliceNum = jobSliceNum;
	}

	public String getJobSliceStrategy() {
		return jobSliceStrategy;
	}

	public void setJobSliceStrategy(String jobSliceStrategy) {
		this.jobSliceStrategy = jobSliceStrategy;
	}

	public String getChildrenJobName() {
		return childrenJobName;
	}

	public void setChildrenJobName(String childrenJobName) {
		this.childrenJobName = childrenJobName;
	}

	public String getExecuteRule() {
		return executeRule;
	}

	public void setExecuteRule(String executeRule) {
		this.executeRule = executeRule;
	}
	
	@Override
	public String toString() {
		return "JobConfig [jobCron=" + jobCron + ", jobDescripte="
				+ jobDescripte + ", jobMaster=" + jobMaster + ", masterEmail="
				+ masterEmail + ", jobSliceNum=" + jobSliceNum
				+ ", jobSliceStrategy=" + jobSliceStrategy
				+ ", childrenJobName=" + childrenJobName + ", executeRule="
				+ executeRule + ", jonStatus=" + jonStatus
				+ ", maxVersionNumber=" + maxVersionNumber + "]";
	}
	
}
