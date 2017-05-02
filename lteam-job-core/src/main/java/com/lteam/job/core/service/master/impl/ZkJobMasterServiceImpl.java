package com.lteam.job.core.service.master.impl;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.lteam.job.common.config.Config;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.execute.ExecuteResult;
import com.lteam.job.common.job.JobStatus;
import com.lteam.job.common.master.MasterConfig;
import com.lteam.job.common.util.GsonUtil;
import com.lteam.job.common.zkServer.IZookeeperCilentApi;
import com.lteam.job.common.zkServer.impl.CuratorKeeperApiImpl;
import com.lteam.job.core.config.master.MasterNode;
import com.lteam.job.core.register.impl.ZkRegisterCenter;
import com.lteam.job.core.service.master.IJobMasterService;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年4月26日 下午5:16:40
 * @version V0.0.1
 */
@Service
public class ZkJobMasterServiceImpl implements IJobMasterService{

	private MasterNode masterNode;
	
	private static CuratorFramework cilent = null ;
	
	private static IZookeeperCilentApi zkApi = new CuratorKeeperApiImpl();
	
	static {
		if(cilent == null){
			cilent = ZkRegisterCenter.getCilent();
		}
		zkApi.setCientObject(cilent);
	}
	
	public String getMasterServiceInfo() {
		return null;
	}

	public ExecuteResult getJobExecuteResult() { 
		return null;
	}

	//TODO -> Exception 自定义处理
	public JobStatus getJobExecuteStatus() {
		JobStatus jobStatus = JobStatus.READY;
		try {
			String status = zkApi.getNodeData(NodePath.getJobExecuteStatus(masterNode.getMasterInfo()));
			if(!StringUtils.isEmpty(status)){
				jobStatus = GsonUtil.gsonToBean(status, JobStatus.class);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jobStatus;
	}

	public MasterNode masterServer() {
		return null;
	}

	public IJobMasterService addMasterConfigInfo(Config config) {
		masterNode = new MasterNode(config);
		return this;
	}

}
