package com.lteam.job.common.zkServer.impl;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

import com.lteam.job.common.config.Node;
import com.lteam.job.common.zkServer.AbstractCuratorKeeperApi;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年4月28日 上午11:01:05
 * @version V0.0.1
 */
public class CuratorKeeperApiImpl extends AbstractCuratorKeeperApi{

	public void createNode(Node node) throws Exception {
		createNode(node.getNodePath(), node.getNodeContent(), null);
	}

	public void createNode(Node node, CreateMode mode) throws Exception {
		createNode(node.getNodePath(), node.getNodeContent(), mode);
	}

	public String getNodeData(Node node) throws Exception {
		return getNodeData(node.getNodePath());
	}

	public Stat getNodeStatusInfo(Node node) throws Exception {
		return getNodeStatusInfo(node.getNodePath());
	}

	public void deleteNodeIncludeLeafNode(Node node) throws Exception {
		deleteNodeIncludeLeafNode(node.getNodePath());
	}

	public void updataNodeData(Node node) throws Exception {
		updataNodeData(node.getNodePath(), node.getNodeContent());
	}

	public boolean versionComparison(Node node) throws Exception {
		return versionComparison(node.getNodePath(), node.getNodeContent());
	}

}
