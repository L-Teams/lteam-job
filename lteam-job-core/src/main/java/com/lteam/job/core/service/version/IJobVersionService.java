package com.lteam.job.core.service.version;
import java.util.List;
import com.lteam.job.common.version.VersionConfig;
import com.lteam.job.core.config.version.VersionNode;
/**
 * @Description:版本信息管理接口
 * @author guicheng.huang
 * @date: 2017年4月27日 下午2:23:37
 * @version V0.0.1
 */
public interface IJobVersionService {

	/**
	 * 功能:获取job版本列表
	 * 逻辑:遍历versionnode节点下所有子结点,并转换为相关对象
	 * @return 版本列表
	 */
	public List<VersionConfig> getJobVersionList();
	
	/**
	 * 功能:获取某一版本的信息
	 * @param version
	 * @return
	 */
	public VersionConfig getJobVersion(String version);
	
	/**
	 * 功能:版本的数量
	 * 逻辑:获取versionnode节点下子结点数量
	 * @return
	 */
	public Integer getJobVersionNum();
	
	/**
	 * 功能:获取当前版本信息
	 * 逻辑:1.获取versionnode下当前版本内容
	 *     2.查询该版本的内容并转换成对象
	 * @return 当前版本
	 */
	public VersionConfig getCurrentVersion();
	
	/**
	 * 功能:获取最老版本的信息
	 * 逻辑:
	 * @return 最老版本
	 */
	public VersionConfig getBestOldVersion();
	
	/**
	 * 功能:处理版本信息
	 * 逻辑:1.判断是否已经订阅了config节点变更事件,如未订阅则订阅
	 *     2.处理版本事件,发生变更则将新版本存入版本节点
	 */
	public void handleVersionInfo();
	
	/**
	 * 功能:添加版本信息
	 * 逻辑:给server添加处理节点,注:server基于节点来处理
	 * @param versionConfig
	 */
	public IJobVersionService addVersionInfo(VersionNode versionNode);
	
	/**
	 * 功能:存储版本信息
	 * 逻辑:1.判断versionnode存在?如果不存在则新增,存在则修改节点内容为新的版本号
	 *     2.判断zookeeper中版本列表的数量,与job config数量对比,如果超出指定数量则删除最老版本。
	 *     3.新增版本节点
	 * @param versionNode
	 */
	public void storeVersionInfo();
	
	/**
	 * 功能:删除最老的版本
	 * 逻辑:
	 */
	public void destoryBestOldVersionInfo();
	
	/**
	 * 功能:删除版本信息
	 * @param version
	 */
	public void destoryVersionInfo(String version);
}
