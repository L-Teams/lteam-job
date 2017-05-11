package com.lteam.job.core.listener;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.job.JobStatus;
import com.lteam.job.common.util.GsonUtil;
import com.lteam.job.common.zkServer.listener.AbstractZkNodeListener;
import com.lteam.job.core.service.config.IJobConfigService;
import com.lteam.job.core.service.config.impl.ZkJobConfigServiceImpl;


/**
 * @Description:job销毁Listener
 * @author guicheng.huang
 * @date: 2017年4月28日 上午11:16:56
 * @version V0.0.1
 */
public class DestoryJobListener extends AbstractZkNodeListener<JobConfig>{
	
	private IJobConfigService jobConfigService = new ZkJobConfigServiceImpl();
	
    public void nodeChanged() throws Exception {
    	JobStatus jobStatus = GsonUtil.gsonToBean(new String(super.cache.getCurrentData().getData()), JobStatus.class);
        if(jobStatus != JobStatus.RUN){
        	jobConfigService.addJobConfigInfo(super.getContext().getContext()).destoryJobInfo();
        }
    }
	
}
