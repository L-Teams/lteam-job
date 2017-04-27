package com.lteam.job.core.service.master.impl;

import org.apache.curator.framework.CuratorFramework;
import org.springframework.beans.factory.annotation.Autowired;

import com.lteam.job.common.execute.ExecuteResult;
import com.lteam.job.common.job.JobStatus;
import com.lteam.job.core.config.master.MasterNode;
import com.lteam.job.core.register.impl.ZkRegisterCenter;
import com.lteam.job.core.service.master.IJobMasterService;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年4月26日 下午5:16:40
 * @version V0.0.1
 */
public class ZkJobMasterServiceImpl implements IJobMasterService{

	private static CuratorFramework cilent = null ;
	@Autowired
	private IZookeeperCilent 
	static {
		if(cilent == null){
			cilent = ZkRegisterCenter.getCilent();
		}
	}
	
	public String getMasterServiceInfo() {
		return null;
	}

	public ExecuteResult getJobExecuteResult() { 
		return null;
	}

	public JobStatus getJobExecuteStatus() {
		return null;
	}

	public IJobMasterService addJobConfigInfo(MasterNode config) {
		// TODO Auto-generated method stub
		return this;
	}

	public MasterNode masterServer() {
		// TODO Auto-generated method stub
		return null;
	}

}
