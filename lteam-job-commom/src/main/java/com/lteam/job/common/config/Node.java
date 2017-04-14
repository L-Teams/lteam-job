package com.lteam.job.common.config;
/**
 * @Description:zookeeper节点父类
 * @author guicheng.huang
 * @date: 2017年4月14日 下午5:56:43
 * @version V0.0.1
 */
public class Node {

	//节点类型
	private String nodeType;
	
	//节点名称
	private String nodeName;
	
	//节点内容
	private String nodeContent;

	public String getNodeType() {
		return nodeType;
	}

	public void setNodeType(String nodeType) {
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
