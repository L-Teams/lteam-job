package com.lteam.job.common.zkServer.listener;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheListener;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年5月3日 上午10:05:11
 * @version V0.0.1
 */
public abstract class AbstractZkChildrenListener extends AbstractZkListener implements PathChildrenCacheListener{

	public PathChildrenCache cache ;
	
	public abstract void childEvent(CuratorFramework client, PathChildrenCacheEvent event)
			throws Exception;

	public AbstractZkListener setCache(CuratorFramework cilent, String path) {
		cache = new PathChildrenCache(cilent, path, true);
		return this;
	}

	public AbstractZkListener setCache(CuratorFramework cilent, String path, boolean dataIsCompressed){
		cache = new PathChildrenCache(cilent, path, dataIsCompressed);
		return this;
	}
	
	public AbstractZkListener addListener(){
		cache.getListenable().addListener(this);
		return this;
	}
	
	public void start() throws Exception{
		cache.start();
	}
	
	public void close() throws Exception{
		cache.close();
	}
}
