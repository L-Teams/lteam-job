package com.lteam.job.common.zkServer;
/**
 * @Description:zookeeper操作封装接口
 * @author guicheng.huang
 * @date: 2017年4月24日 下午6:23:53
 * @version V0.0.1
 */
public interface IZookeeperCilent {

	/**
	 * 功能:判断节点路径是否存在
	 * @param path
	 * @return
	 */
	public boolean isExistPath(String path);
	
	/**
	 * g
	 * @param path
	 * @param data
	 */
	public void createNode(String path,String data);
}
