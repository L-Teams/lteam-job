package com.lteam.job.common.config;
/**
 * @Description:zookeeper节点父类
 * @author guicheng.huang
 * @date: 2017年4月14日 下午5:56:43
 * @version V0.0.1
 */
public class Node {

	//节点类型
	protected NodeType nodeType;
	
	//节点名称
	protected String nodeName;
	
	//节点内容
	protected String nodeContent;

	public NodeType getNodeType() {
		return nodeType;
	}

	public void setNodeType(NodeType nodeType) {
		this.nodeType = nodeType;
	}

	public String getNodeName() {
		return nodeName;
	}

	public void setNodeName(String nodeName) {
		this.nodeName = nodeName;
	}

	public String getNodeContent() {
		return nodeContent;
	}

	public void setNodeContent(String nodeContent) {
		this.nodeContent = nodeContent;
	}
}
