package com.lteam.job.common.zkServer.listener;

import org.apache.curator.framework.CuratorFramework;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年5月3日 上午10:38:42
 * @version V0.0.1
 */
public abstract class AbstractZkListener {
	
	public abstract AbstractZkListener setCache(CuratorFramework cilent, String path);
	
	public abstract AbstractZkListener setCache(CuratorFramework cilent, String path, boolean dataIsCompressed);
	
	public abstract AbstractZkListener addListener();
	
	public abstract void start() throws Exception;
	
	public abstract void close() throws Exception;
	
}
