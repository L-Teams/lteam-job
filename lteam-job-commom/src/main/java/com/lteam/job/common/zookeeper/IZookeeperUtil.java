package com.lteam.job.common.zookeeper;
/**
 * @Description:Zookeeper工具接口定义
 * @author guicheng.huang
 * @date: 2017年4月17日 上午10:21:11
 * @version V0.0.1
 */
public interface IZookeeperUtil {

	/**
	 * 初始化客户端连接
	 */
	public void inital();
	
	public void close();
	
	public void addNode();
	
}
