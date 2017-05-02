package com.lteam.example.javajob;

import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.zkServer.factory.config.RegisterCenterConfig;
import com.lteam.job.core.register.impl.ZkRegisterCenter;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年5月2日 上午11:07:24
 * @version V0.0.1
 */
public class JavaMain {

    public static void main(String[] args) {
    	//定义job
    	JobConfig job = getJob();
    	//获取连接zookeeper信息
    	RegisterCenterConfig centerConfig = getZkConfig();
    	//获取注册中心
    	ZkRegisterCenter zkcenter = getRegisterCenter();
    	zkcenter.setCenterConfig(centerConfig);
    	zkcenter.setJobConfig(job);
    	//注册信息
    	zkcenter.inital();
	}
    
    private static JobConfig getJob(){
    	JobConfig job = new JobConfig().builer("simpleJob", "1 0/30 * * * ?")
				        .addJobMaster("hgc")
				        .addMasterEmail("862896568@qq.com")
				        .addJobSliceStrategy("A=1;B=2;C=3")
				        .addJobSliceNum(3);
    	job.setSystemName("lteam-job-example");
    	return job;
    }
    
    private static RegisterCenterConfig getZkConfig(){
    	RegisterCenterConfig centerConfig = new RegisterCenterConfig();
    	centerConfig.setBaseSleepTimeMilliseconds(1000);
    	centerConfig.setConnectionTimeoutMilliseconds(1000);
    	centerConfig.setMaxRetries(3);
    	centerConfig.setNameSpace("lteam-job");
    	centerConfig.setServersList("localhost:2181");
    	centerConfig.setSessionTimeoutMilliseconds(1000);
    	centerConfig.setMaxSleepTimeMilliseconds(3000);
    	return centerConfig;
    }
    
    private static ZkRegisterCenter getRegisterCenter(){
    	ZkRegisterCenter zkcenter = new ZkRegisterCenter();
    	return zkcenter;
    }
}
