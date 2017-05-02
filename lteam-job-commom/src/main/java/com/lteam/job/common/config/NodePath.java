package com.lteam.job.common.config;

import com.lteam.job.common.execute.ExecuteConfig;
import com.lteam.job.common.server.ServerConfig;

/**
 * @Description:lteam-job服务zookeeper节点路径
 * @author guicheng.huang
 * @date: 2017年4月18日 下午6:11:11
 * @version V0.0.1
 */
public class NodePath {

	public static final String ROOT = "/lteam-job";
	
	static final String JOBPATH = ROOT+"/%s/%s";
	
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
	
	static final String EXECUTEJOBSELEICEPATH = EXECUTENODEPATH+"/%s";
	
	static final String MASTERNODENAME = "masternode";
	
	static final String MASTERNODEPATH = ROOT+"/%s/%s/"+MASTERNODENAME;
	
	static final String MASTERSERVERNODENAME = "masterserver";
	
	static final String MASTERSERVERPATH = MASTERNODEPATH+"/"+MASTERSERVERNODENAME;
	
	static final String ROUTINGSTRATEGYNODENAME = "routStrategy";
	
	static final String ROUTINGSTRATEGYPATH = MASTERNODEPATH+"/"+ROUTINGSTRATEGYNODENAME;
	
	static final String LOGSERVICENODENAME = "logservice";
	
	static final String LOGSERVICEPATH = MASTERNODEPATH+"/"+LOGSERVICENODENAME;
	
	static final String JOBEXECUTESTATUSNODENAME = "jobexecutestatus";
	
	static final String JOBEXECUTESTATUSPATH = MASTERNODEPATH+"/"+JOBEXECUTESTATUSNODENAME;
	
	static final String JOBEXECUTETRESULTNODENAME = "jobexecuteresult";
	
	static final String JOBEXECUTETRESULTPATH =  MASTERNODEPATH+"/"+JOBEXECUTETRESULTNODENAME;
	
	static final String VERSIONNODENAME = "versionnode";
	
	static final String VERSIONPATH = ROOT+"/%s/%s/"+VERSIONNODENAME;;
	
	public static String getJobPath(Config config){
		return String.format(JOBPATH, config.getSystemName(), config.getJobName());
	}
	
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
	
	public static String getMasterNodePath(Config config){
		return String.format(MASTERNODEPATH, config.getSystemName(), config.getJobName());
	}
	
	public static String getMasterServerPath(Config config){
		return String.format(MASTERSERVERPATH, config.getSystemName(), config.getJobName());
	}
	
	public static String getRoutingStrategyPath(Config config){
		return String.format(ROUTINGSTRATEGYPATH, config.getSystemName(), config.getJobName());
	}
	
	public static String getLogServicePath(Config config){
		return String.format(LOGSERVICEPATH, config.getSystemName(), config.getJobName());
	}
	
	public static String getJobExecuteStatus(Config config){
		return String.format(JOBEXECUTESTATUSPATH, config.getSystemName(), config.getJobName());
	}
	
	public static String getJobExecuteResult(Config config){
		return String.format(JOBEXECUTETRESULTPATH, config.getSystemName(), config.getJobName());
	}
	
	public static String getExecuteServicePath(Config config){
		return String.format(EXECUTENODEPATH, config.getSystemName(), config.getJobName());
	}
	
	public static String getExecuteSlienceJobServicePath(ExecuteConfig config){
		return String.format(EXECUTEJOBSELEICEPATH, config.getSystemName(), config.getJobName(), config.getSilenceJobName());
	}
	
	public static String getVersionPath(Config config){
		return String.format(VERSIONPATH, config.getSystemName(), config.getJobName());
	}
}
