package com.lteam.job.common.zkServer.listener;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.NodeCache;
import org.apache.curator.framework.recipes.cache.NodeCacheListener;
import com.lteam.job.common.context.Context;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年5月3日 上午9:59:35
 * @version V0.0.1
 * @param <T>
 * @param <T>
 */
public abstract class AbstractZkNodeListener<T> extends AbstractZkListener implements NodeCacheListener{

	public NodeCache cache ;
	
    public Boolean isNowListener ;
    
    public Context<T> context ;//上下文
    
	public abstract void nodeChanged() throws Exception;

	public AbstractZkListener setCache(CuratorFramework cilent, String path) {
		cache = new NodeCache(cilent, path);
		return this;
	}

	public AbstractZkListener setCache(CuratorFramework cilent, String path, boolean isNowListener){
		this.isNowListener = isNowListener;
		cache = new NodeCache(cilent, path, false);
		return this;
	}
	
	public AbstractZkListener addListener(){
		cache.getListenable().addListener(this);
		return this;
	}
	
	public AbstractZkNodeListener<T> setContext(Context<T> context){
		this.context = context;
		return this;
	}
	
	public Context<T> getContext(){
		return this.context;
	}
	
	public void start() throws Exception{
		if(isNowListener){
		   cache.start(true);
		   return ;
		}
		cache.start();
	}
	
	public void close() throws Exception{
		cache.close();
	}
}
