package com.lteam.job.common.job;

import com.lteam.job.common.config.Config;

/**
 * @Description:job配置信息
 * @author guicheng.huang
 * @date: 2017年4月18日 下午4:59:49
 * @version V0.0.1
 */
public class JobConfig extends Config{

	private String jobName;
	
	private String jobCron;
	
	private String jobDescripte;
	
	private String jobMaster;
	
	private String masterEmail;
	
	private int jobSliceNum;
	
	private String jobSliceStrategy;
	
	private String childrenJobName;
	
	private String executeRule;
	
	private JobStatus jonStatus = JobStatus.RUN;
	
	public JobConfig(){}
	
	public JobConfig(String jobName, String jobCron){
		this.jobName = jobName;
		this.jobCron = jobCron;
	}
	
	public JobConfig builer(String jobName, String jobCron){
		return new JobConfig(jobName, jobCron);
	}

	private JobConfig addJobStatus(JobStatus jobStatus){
		this.setJonStatus(jonStatus);
		return this;
	}
	
	private JobConfig addJobDescripte(String jobDescripte){
		this.setJobDescripte(jobDescripte);
		return this;
	}

	private JobConfig addJobMaster(String jobMaster){
		this.setJobMaster(jobMaster);
		return this;
	}
	
	private JobConfig addMasterEmail(String masterEmail){
		this.setMasterEmail(masterEmail);
		return this;
	}
	
	private JobConfig addJobSliceNum(int jobSliceNum){
		this.setJobSliceNum(jobSliceNum);
		return this;
	}
	
	private JobConfig addJobSliceStrategy(String jobSliceStrategy){
		this.setJobSliceStrategy(jobSliceStrategy);
		return this;
	}
	
	private JobConfig addChildrenJobName(String childrenJobName){
		this.setChildrenJobName(childrenJobName);
		return this;
	}
	
	private JobConfig addExecuteRule(String executeRule){
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
}
