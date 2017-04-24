package com.lteam.job.core.config.execute;
import com.lteam.job.common.config.Node;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.config.NodeType;
import com.lteam.job.common.execute.ExecuteConfig;
/**
 * @Description:执行器节点
 * @author guicheng.huang
 * @date: 2017年4月17日 上午9:56:05
 * @version V0.0.1
 */
public class ExecuteNode extends Node{

	//任务分片节点路径
	private String executejobSlicePath;
	
	public ExecuteNode(){
		nodeType = NodeType.EXECUTENODE;
		nodeName = ExecuteNode.class.getSimpleName().toLowerCase();
	}
	
	public ExecuteNode addExecuteInfo(ExecuteConfig config){
		executejobSlicePath = NodePath.getExecuteSlienceJobServicePath(config);
		nodePath= NodePath.getExecuteServicePath(config);
		return this;
	}
}
