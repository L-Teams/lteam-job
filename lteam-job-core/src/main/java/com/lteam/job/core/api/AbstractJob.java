package com.lteam.job.core.api;
/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年5月2日 上午10:45:26
 * @version V0.0.1
 */
public abstract class AbstractJob implements LteamJob{

	/*
	 * 功能:规范定义job抽象方法
	 * 逻辑:
	 */
	public abstract void execute();

	
}
