package com.lteam.job.core.register;
/**
 * @Description:注册器接口
 * @author guicheng.huang
 * @date: 2017年4月17日 上午10:30:13
 * @version V0.0.1
 */
public interface IRegister {

	/**
	 * 功能:初始化注册中心
	 * 逻辑:
	 */
	public void inital();
	
	/**
	 * 功能:关闭注册中心
	 * 逻辑:
	 */
	public void close();
	
	/**
	 * 功能:添加注册信息
	 * 逻辑:
	 */
	public void addRegisterInfo();
	
	
	
	
}
