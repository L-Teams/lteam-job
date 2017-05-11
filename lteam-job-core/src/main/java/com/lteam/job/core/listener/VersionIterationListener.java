package com.lteam.job.core.listener;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.util.GsonUtil;
import com.lteam.job.common.zkServer.listener.AbstractZkNodeListener;
import com.lteam.job.core.config.version.VersionNode;
import com.lteam.job.core.service.version.IJobVersionService;
import com.lteam.job.core.service.version.impl.ZkJobVersionServiceImpl;
/**
 * @Description:版本迭代监听
 *             :job配置信息修改时触发
 * @author guicheng.huang
 * @date: 2017年4月28日 上午10:28:04
 * @version V0.0.1
 */
public class VersionIterationListener extends AbstractZkNodeListener<JobConfig> {

	IJobVersionService jobVersionService = new ZkJobVersionServiceImpl();
	
	public void nodeChanged() throws Exception {
		JobConfig jobConfig = GsonUtil.gsonToBean(new String(super.cache.getCurrentData().getData()), JobConfig.class);
		jobVersionService.addVersionInfo(new VersionNode().addVersionInfo(jobConfig)).storeVersionInfo();
	}

}
