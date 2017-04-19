package com.lteam.job.common.zookeeper;

import org.I0Itec.zkclient.ZkClient;

/**
 * @Description:基于ZkClient实现zookeeper操作
 * @author guicheng.huang
 * @date: 2017年4月17日 下午6:46:18
 * @version V0.0.1
 */
public abstract class ZkClientUtil implements IZookeeperUtil {

	/**
	 * 获取ZkClient 对象
	 * @return
	 */
	public abstract ZkClient getZookeeperConnect();
	
	
}
