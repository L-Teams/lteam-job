package com.lteam.job.common.zkServer;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.api.ProtectACLCreateModePathAndBytesable;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import com.lteam.job.common.config.Node;
import com.lteam.job.common.zkServer.listener.AbstractZkListener;

/**
 * @Description:基于Curator实现abstract api
 * @author guicheng.huang
 * @date: 2017年4月27日 上午11:14:37
 * @version V0.0.1
 */
public abstract class AbstractCuratorKeeperApi implements IZookeeperCilentApi{

	private CuratorFramework cilent;
	
	public abstract void createNode(Node node) throws Exception;
	    
	public abstract void createNode(Node node,CreateMode mode) throws Exception;
	
	public abstract String getNodeData(Node node) throws Exception;
	
	public abstract Stat getNodeStatusInfo(Node node) throws Exception;
	
	public abstract void deleteNodeIncludeLeafNode(Node node) throws Exception;
	
	public abstract void updataNodeData(Node node) throws Exception;
	
	public abstract boolean versionComparison(Node node) throws Exception;
	
	public boolean isExistPath(String path) throws Exception {
		if(cilent.checkExists()
				 .forPath(path) != null){
			return true ;
		}
		return false ;
	}

	public void createNode(String path, String data, CreateMode mode) throws Exception {
		ProtectACLCreateModePathAndBytesable<String> createModeal = 
		    cilent.create()
		          .creatingParentsIfNeeded();
			if(mode != null){
				createModeal.withMode(mode);
			}
			createModeal.forPath(path,data.getBytes());
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
	
	public void deleteNodeIncludeLeafNode(String path) throws Exception {
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

	public void addNodeListener(String path, boolean dataIsCompressed, AbstractZkListener listener) throws Exception {
		
	}
}
