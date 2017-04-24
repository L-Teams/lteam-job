package com.lteam.job.core.register;
/**
 * @Description:RegisterCenter抽象类
 * @author guicheng.huang
 * @date: 2017年4月24日 上午11:08:34
 * @version V0.0.1
 */
public abstract class RegisterCenter implements IRegister{

    /**
     * 功能:注册job信息
     * 逻辑:
     */
	public abstract void registerJobConfigInfo();
	
	/**
	 * 功能:注册服务器信息
     * 逻辑:
	 */
	public abstract void registerServerConfigInfo();
	
	/**
	 * 功能:注册任务分片信息
	 * 逻辑:
	 */
	public abstract void registerSilenceJobConfigInfo();
	
	/**
	 * 功能:注册主节点信息
	 * 逻辑:
	 */
	public abstract void registerMasterConfigInfo();
	
	/**
	 * 功能:注册执行器信息
	 * 逻辑:
	 */
	public abstract void registerExecuterConfigInfo();
}
