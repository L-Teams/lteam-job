package com.lteam.job.common.zkServer.impl;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;

import com.lteam.job.common.zkServer.IZookeeperCilentApi;

/**
 * @Description:基于Curator实现api
 * @author guicheng.huang
 * @date: 2017年4月27日 上午11:14:37
 * @version V0.0.1
 */
public class CuratorKeeperApi implements IZookeeperCilentApi{

	private CuratorFramework cilent;
	
	public boolean isExistPath(String path) throws Exception {
		if(cilent.checkExists()
				 .forPath(path) != null){
			return true ;
		}
		return false ;
	}

	public void createNode(String path, String data) throws Exception {
		cilent.create()
		      .creatingParentsIfNeeded()
		      .forPath(path,data.getBytes());
	}

	public String getNodeData(String path) throws Exception {
		byte[] data = cilent.getData()
				            .forPath(path);
		return new String(data);
	}

	public Stat getNodeStatusInfo(String path) throws Exception {
		Stat stat = new Stat();
		cilent.getData()
		      .storingStatIn(stat)
		      .forPath(path);
		return stat;
	}

	public void deleteNode(String path) throws Exception {
		cilent.delete()
		      .deletingChildrenIfNeeded()
		      .forPath(path);
	}

	public void updataNodeData(String path, String data) throws Exception {
		cilent.setData()
		      .forPath(path, data.getBytes());
	}

	public boolean versionComparison(String path, String data) throws Exception {
		String ovData = getNodeData(path);
		if(ovData != null && ovData.equals(data)){
			return true;
		}
		return false;
	}
	
	public <T> void setCientObject(T t) {
		cilent = (CuratorFramework) t;
	}	

}
