package com.lteam.job.core.config.version;
import java.util.List;

import com.lteam.job.common.config.Node;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.config.NodeType;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.util.GsonUtil;
import com.lteam.job.common.version.VersionConfig;
import com.lteam.job.core.service.version.IJobVersionService;
import com.lteam.job.core.service.version.impl.ZkJobVersionServiceImpl;

/**
 * @Description:版本节点
 * @author guicheng.huang
 * @date: 2017年4月27日 下午2:18:08
 * @version V0.0.1
 */
public class VersionNode extends Node{
	
	private IJobVersionService jobVersionService = new ZkJobVersionServiceImpl();
	
	//历史版本路径
	private String versionHistoryPath;
	
	//历史版本内容
	private String versionHistoryContent;
	
	//版本信息配置
	private VersionConfig verSionConfig;
	
	public VersionNode(){
		nodeType = NodeType.VERSIONNODE;
		nodeName = VersionNode.class.getSimpleName().toLowerCase();
	}
	
	public VersionNode addVersionInfo(JobConfig jobConfig){
		verSionConfig = new VersionConfig().addJobConfig(jobConfig);
		nodePath = NodePath.getVersionPath(jobConfig);
		nodeContent = verSionConfig.getVersion();
		versionHistoryPath = NodePath.getVersionPath(jobConfig) +"/"+ verSionConfig.getVersion();
		versionHistoryContent = GsonUtil.gsonString(verSionConfig);
		return this;
	}

	/**
	 * 功能:存储版本节点信息
	 * 逻辑:
	 */
	public void storeVersionInfo(){
		jobVersionService.addVersionInfo(getVersionInfo())
		                 .handleVersionInfo();
	}
	
    /**
     * 功能:获取版本数量
     * 逻辑:
     * @return
     */
	public int getJobVersionNum(){
		return jobVersionService.addVersionInfo(this).getJobVersionNum();
	}
	
	/**
	 * 功能:获取某一版本的配置信息
	 * 逻辑:
	 * @param version
	 * @return
	 */
	public VersionConfig getJobVersion(String version){
		return jobVersionService.addVersionInfo(this).getJobVersion(version);
	}
	
	/**
	 * 功能:获取版本列表
	 * 逻辑:
	 * @return
	 */
	public List<VersionConfig> getJobVersionList(){
		return jobVersionService.addVersionInfo(this).getJobVersionList();
	}
	
	/**
	 * 功能:获取当前版本
	 * 逻辑:
	 * @return
	 */
	public VersionConfig getCurrentVersion(){
		return jobVersionService.addVersionInfo(this).getCurrentVersion();
	}
	
	/**
	 * 功能:设置某一版本的当前版本
	 * 逻辑:
	 * @param version
	 */
	public void setCurrentVersion(String version){
		
	}
	
	/**
	 * 功能:更新某一版本
	 * 逻辑:
	 * @param config
	 */
	public void updataVersion(VersionConfig config){
		
	}
	
	/**
	 * 功能:删除某一版本信息
	 * 逻辑:
	 */
	public void destoryVersionInfo(String version){
		 jobVersionService.addVersionInfo(this).destoryVersionInfo(version);
	}
	
	//>>>>>>>>>>>>>>>>>>>>>>>>>>set get method>>>>>>>>>>>>>>>>>>>>>>>>>>>
	public String getVersionHistoryPath() {
		return versionHistoryPath;
	}

	public void setVersionHistoryPath(String versionHistoryPath) {
		this.versionHistoryPath = versionHistoryPath;
	}

	public String getVersionHistoryContent() {
		return versionHistoryContent;
	}

	public void setVersionHistoryContent(String versionHistoryContent) {
		this.versionHistoryContent = versionHistoryContent;
	}

	public VersionNode getVersionInfo(){
		return this;
	}
	
	public VersionConfig getVersionConfig(){
		return this.verSionConfig;
	}
}
