package com.lteam.job.common.context;
/**
 * @Description:上下文
 * @author guicheng.huang
 * @date: 2017年5月11日 下午2:58:19
 * @version V0.0.1
 * @param <T>
 */
public class Context<T> {

	private Class<T> type;
	private T context;
	
	public Context(Class<T> type,T context){
		this.type = type;
		this.context = context;
	}
	public Class<T> getType() {
		return type;
	}
	public void setType(Class<T> type) {
		this.type = type;
	}
	public T getContext() {
		return context;
	}
	public void setContext(T context) {
		this.context = context;
	}
	
	
}
