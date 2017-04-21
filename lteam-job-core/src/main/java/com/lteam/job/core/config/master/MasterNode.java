package com.lteam.job.core.config.master;

import com.lteam.job.common.config.Node;
import com.lteam.job.common.config.NodeType;
import com.lteam.job.core.config.server.ServersNode;

/**
 * @Description:主节点
 * @author guicheng.huang
 * @date: 2017年4月17日 上午9:57:08
 * @version V0.0.1
 */
public class MasterNode extends Node{

	public MasterNode(){
		nodeType = NodeType.MASTERNODE;
		nodeName = MasterNode.class.getSimpleName().toLowerCase();
	}
}
