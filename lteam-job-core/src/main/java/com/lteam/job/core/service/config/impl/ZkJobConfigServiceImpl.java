package com.lteam.job.core.service.config.impl;
import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.job.JobStatus;
import com.lteam.job.common.zkServer.IZookeeperCilentApi;
import com.lteam.job.common.zkServer.impl.CuratorKeeperApiImpl;
import com.lteam.job.core.config.config.ConfigNode;
import com.lteam.job.core.listener.manager.DestoryJobListener;
import com.lteam.job.core.register.impl.ZkRegisterCenter;
import com.lteam.job.core.service.config.IJobConfigService;
import com.lteam.job.core.service.master.IJobMasterService;
import com.lteam.job.core.service.master.impl.ZkJobMasterServiceImpl;

/**
 * @Description:job配置信息服务实现类
 * @author guicheng.huang
 * @date: 2017年4月26日 下午3:11:54
 * @version V0.0.1
 */
@Service
public class ZkJobConfigServiceImpl implements IJobConfigService{

	private ConfigNode configNode;
	
	private static CuratorFramework cilent = null ; 
	
	private static IZookeeperCilentApi zkApi = new CuratorKeeperApiImpl();
	
	private IJobMasterService jobMasterService = new ZkJobMasterServiceImpl();
	
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
			JobStatus status = jobMasterService.addMasterConfigInfo(configNode.getJobInfo())
			              					   .getJobExecuteStatus();
			if(status == JobStatus.RUN){
				zkApi.addNodeListener(NodePath.getJobExecuteStatus(configNode.getJobInfo()), true, new DestoryJobListener());
				return ;
			}
			zkApi.deleteNodeIncludeLeafNode(NodePath.getJobPath(configNode.getJobInfo()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
