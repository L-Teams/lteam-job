package com.lteam.job.core.service.config.impl;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.springframework.beans.factory.annotation.Autowired;

import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.zkServer.IZookeeperCilentApi;
import com.lteam.job.core.config.config.ConfigNode;
import com.lteam.job.core.register.impl.ZkRegisterCenter;
import com.lteam.job.core.service.config.IJobConfigService;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年4月26日 下午3:11:54
 * @version V0.0.1
 */
public class ZkJobConfigServiceImpl implements IJobConfigService{

	private ConfigNode configNode;
	
	private static CuratorFramework cilent = null ; 
	
	@Autowired
	private static IZookeeperCilentApi zkApi;
	
	static {
		if(cilent == null){
		   cilent = ZkRegisterCenter.getCilent();
		}
		zkApi.setCientObject(cilent);
	}
	
	public IJobConfigService addJobConfigInfo(JobConfig config){
		this.configNode = new ConfigNode().addJobInfo(config);
		return this;
	}
	
	//TODO -> Exception 自定义处理
	public void handleJobInfo(){
		try {
			if(!zkApi.isExistPath(configNode.getNodePath())){
				zkApi.createNode(configNode);	
			}else{
				if(!zkApi.versionComparison(configNode)){
					zkApi.updataNodeData(configNode);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//TODO -> Exception 自定义处理
	public void destoryJobInfo(){
		try {
			cilent.delete()
			      .deletingChildrenIfNeeded()
			      .forPath(NodePath.getJobPath(configNode.getJobInfo()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
