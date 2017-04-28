package com.lteam.job.core.service.version;
import java.util.List;
import com.lteam.job.common.version.VersionConfig;
/**
 * @Description:版本信息管理接口
 * @author guicheng.huang
 * @date: 2017年4月27日 下午2:23:37
 * @version V0.0.1
 */
public interface IJobVersionService {

	/**
	 * 功能:获取job版本列表
	 * 逻辑:
	 * @return 版本列表
	 */
	public List<VersionConfig> getJobVersionList();
	
	/**
	 * 功能:获取当前版本信息
	 * @return 当前版本
	 */
	public VersionConfig getCurrentVersion();
	
	/**
	 * 功能:处理版本信息
	 * 逻辑:1.判断是否已经订阅了config节点变更事件,如未订阅则订阅
	 *     2.处理版本事件,发生变更则将新版本存入版本节点
	 */
	public void handleVersionInfo();
	
	/**
	 * 功能:添加版本信息
	 * @param versionConfig
	 */
	public void addVersionInfo(VersionConfig versionConfig);
	
	/**
	 * 功能:删除版本信息
	 * @param version
	 */
	public void destoryVersionInfo(int version);
}