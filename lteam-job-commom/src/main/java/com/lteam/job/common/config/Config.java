package com.lteam.job.common.config;
/**
 * @Description:所有配置的父类
 * @author guicheng.huang
 * @date: 2017年4月18日 下午6:27:06
 * @version V0.0.1
 */
public class Config {

	public String rootPath = NodePath.ROOT;
	
    public String systemName;
	
    public String jobName;
	
	public Config(){}
	
	public Config(Config config){
		this.systemName = config.getSystemName();
		this.jobName = config.getJobName();
	}
	
	public String getRootPath() {
		return rootPath;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public String getSystemName() {
		return systemName;
	}

	public void setSystemName(String systemName) {
		this.systemName = systemName;
	}

	public String getJobName() {
		return jobName;
	}

	public void setJobName(String jobName) {
		this.jobName = jobName;
	}

}
