package com.lteam.job.core.service.common;

import com.lteam.job.common.zkServer.factory.config.RegisterCenterConfig;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年5月10日 上午11:10:32
 * @version V0.0.1
 */
public class ZkRegisterCenterCommon {

	public static RegisterCenterConfig getRegisterCenterConfig(){
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
}
