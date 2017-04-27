package com.lteam.job.common.zkServer;

import org.apache.zookeeper.data.Stat;

/**
 * @Description:zookeeper操作封装接口
 * @author guicheng.huang
 * @date: 2017年4月24日 下午6:23:53
 * @version V0.0.1
 */
public interface IZookeeperCilentApi {

	/**
	 * 功能:判断节点路径是否存在
	 * @param path
	 * @return
	 * @throws Exception 
	 */
	public boolean isExistPath(String path) throws Exception;
	
	/**
	 * 功能:创建节点
	 * @param path
	 * @param data
	 * @throws Exception 
	 */
	public void createNode(String path,String data) throws Exception;
	
	/**
	 * 功能:获取结点的数据
	 * @param path
	 * @return
	 * @throws Exception 
	 */
	public String getNodeData(String path) throws Exception;
	
	/**
	 * 功能:获取结点的状态信息
	 * @param path
	 * @return
	 * @throws Exception 
	 */
	public Stat getNodeStatusInfo(String path) throws Exception;
	
	/**
	 * 功能:删除节点包括子结点
	 * @param path
	 * @throws Exception 
	 */
	public void deleteNode(String path) throws Exception;
	
	/**
	 * 功能:修改节点的数据信息
	 * @param path
	 * @param data
	 * @throws Exception 
	 */
	public void updataNodeData(String path, String data) throws Exception;
	
	/**
	 * 功能:版本对比
	 * @param path
	 * @param data
	 * @return
	 * @throws Exception
	 */
	public boolean versionComparison(String path, String data) throws Exception;
	
	/**
	 * 功能:设置连接客户端对象
	 * @param t
	 */
	public <T> void setCientObject(T t);
	
}
