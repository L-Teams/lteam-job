package com.lteam.job.core.config.version;

import com.lteam.job.common.config.Node;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.config.NodeType;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.util.GsonUtil;
import com.lteam.job.common.version.VersionConfig;
import com.lteam.job.core.config.config.ConfigNode;
import com.lteam.job.core.config.execute.ExecuteNode;

/**
 * @Description:版本节点
 * @author guicheng.huang
 * @date: 2017年4月27日 下午2:18:08
 * @version V0.0.1
 */
public class VersionNode extends Node{

	public VersionNode(){
		nodeType = NodeType.VERSIONNODE;
		nodeName = VersionNode.class.getSimpleName().toLowerCase();
	}
	
	public VersionNode addVersionInfo(VersionConfig varsionConfig){
		
		return this;
	}
	
	/**
	 * 功能:存储版本节点信息
	 * 逻辑:
	 */
	public void storeVersionInfo(){
		
	}
}
