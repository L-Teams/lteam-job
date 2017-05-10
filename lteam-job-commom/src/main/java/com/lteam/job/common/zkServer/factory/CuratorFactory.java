package com.lteam.job.common.zkServer.factory;
import java.util.Date;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorFrameworkFactory.Builder;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.log4j.Logger;

import com.lteam.job.common.zkServer.factory.config.RegisterCenterConfig;

/**
 * @Description:基于Curator连接工厂
 * @author guicheng.huang
 * @date: 2017年5月2日 下午2:34:11
 * @version V0.0.1
 */
public class CuratorFactory {
	
	private static final Logger logger = Logger.getLogger(CuratorFactory.class);
	
	public static CuratorFramework getCurator(RegisterCenterConfig centerConfig){
		
		logger.info("lteam-job >>inital curator api client start >>"+new Date());
		logger.info("lteam-job >> connect zookeeper host list = "+centerConfig.getServersList());
		
		Builder bulider = CuratorFrameworkFactory.builder()
									             .connectString(centerConfig.getServersList())
									             .retryPolicy(new ExponentialBackoffRetry(centerConfig.getBaseSleepTimeMilliseconds(), centerConfig.getMaxRetries(), centerConfig.getMaxSleepTimeMilliseconds()));
		if (0 != centerConfig.getSessionTimeoutMilliseconds()) {
			bulider.sessionTimeoutMs(centerConfig.getSessionTimeoutMilliseconds());
		}
		if (0 != centerConfig.getConnectionTimeoutMilliseconds()) {
			bulider.connectionTimeoutMs(centerConfig.getConnectionTimeoutMilliseconds());
		}
		logger.info("lteam-job >>inital curator api client end >>"+new Date());
		return bulider.build();
	}
}
