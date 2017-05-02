package com.lteam.job.common.zkServer.factory;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.CuratorFrameworkFactory.Builder;
import org.apache.curator.retry.ExponentialBackoffRetry;

import com.lteam.job.common.zkServer.factory.config.RegisterCenterConfig;

/**
 * @Description:基于Curator连接工厂
 * @author guicheng.huang
 * @date: 2017年5月2日 下午2:34:11
 * @version V0.0.1
 */
public class CuratorFactory {

	public static CuratorFramework getCurator(RegisterCenterConfig centerConfig){
		Builder bulider = CuratorFrameworkFactory.builder()
									             .connectString(centerConfig.getServersList())
									             .namespace(centerConfig.getNameSpace())
									             .retryPolicy(new ExponentialBackoffRetry(centerConfig.getBaseSleepTimeMilliseconds(), centerConfig.getMaxRetries(), centerConfig.getMaxSleepTimeMilliseconds()));
		if (0 != centerConfig.getSessionTimeoutMilliseconds()) {
			bulider.sessionTimeoutMs(centerConfig.getSessionTimeoutMilliseconds());
		}
		if (0 != centerConfig.getConnectionTimeoutMilliseconds()) {
			bulider.connectionTimeoutMs(centerConfig.getConnectionTimeoutMilliseconds());
		}
		return bulider.build();
	}
}
