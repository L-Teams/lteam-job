package com.lteam.job.common.config;

import com.lteam.job.common.server.ServerConfig;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年4月18日 下午6:11:11
 * @version V0.0.1
 */
public class NodePath {

	public static final String ROOT = "/lteam-job";
	
	static final String CONFIGNODENAME = "confignode";
	
	static final String CONFIGNODEPATH = ROOT+"/%s/%s/"+CONFIGNODENAME;
	
	static final String SERVERSNODENAME = "serversnode";
	
	static final String SERVERSNODEPATH = ROOT+"/%s/%s/"+SERVERSNODENAME;
	
	static final String HOSTFAILSERVERNODENAME = "failjobnum";
	
	static final String HOSTFAILSERVERNODEPATH = SERVERSNODEPATH+"/%s/"+HOSTFAILSERVERNODENAME;
	
	static final String HOSTSUCCESSSERVERNODENAME = "successjobnum";
	
	static final String HOSTSUCCESSSERVERNODEPATH = SERVERSNODEPATH+"/%s/"+HOSTSUCCESSSERVERNODENAME;
	
	static final String EXECUTENODENAME = "executenode";
	
	static final String EXECUTENODEPATH = ROOT+"/%s/%s/"+EXECUTENODENAME;
	
	static final String MASTERNODENAME = "masternode";
	
	static final String MASTERNODEPATH = ROOT+"/%s/%s/"+MASTERNODENAME;
	

	public static String getConfigPath(Config config){
		return String.format(CONFIGNODEPATH, config.getSystemName(), config.getJobName());
	}
	
	public static String getServersPath(Config config){
		return String.format(SERVERSNODEPATH, config.getSystemName(), config.getJobName());
	}
	
	public static String getFailServerPath(ServerConfig config){
		return String.format(HOSTSUCCESSSERVERNODEPATH,config.getSystemName(), config.getJobName(), config.getHostName());
	}
	
	public static String getSuccessServerPath(ServerConfig config){
		return String.format(HOSTFAILSERVERNODEPATH,config.getSystemName(), config.getJobName(), config.getHostName());
	}
	
	public static String getMasterServerPath(Config config){
		return String.format(MASTERNODEPATH, config.getSystemName(), config.getJobName());
	}
}
