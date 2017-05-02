package com.lteam.job.core.config.version;
import com.lteam.job.common.config.Node;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.config.NodeType;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.version.VersionConfig;

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
	
	public VersionNode addVersionInfo(JobConfig jobConfig){
		nodePath = NodePath.getVersionPath(jobConfig);
		VersionConfig verSionConfig = new VersionConfig().addJobConfig(jobConfig);
		return this;
	}
	
	/**
	 * 功能:存储版本节点信息
	 * 逻辑:
	 */
	public void storeVersionInfo(){
		
	}
}
