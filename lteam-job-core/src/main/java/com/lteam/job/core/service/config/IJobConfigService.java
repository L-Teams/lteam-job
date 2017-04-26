package com.lteam.job.core.service.config;

import com.lteam.job.common.job.JobConfig;
import com.lteam.job.core.config.config.ConfigNode;

/**
 * @Description:job 配置信息服务接口
 * @author guicheng.huang
 * @date: 2017年4月26日 下午3:07:22
 * @version V0.0.1
 */
public interface IJobConfigService {

	/**
	 * 功能:添加配置信息
	 * @param config
	 */
	public IJobConfigService addJobConfigInfo(ConfigNode config);
	
	/**
	 * 功能:处理job配置信息
	 * 逻辑:
	 */
	public void handleJobInfo();
	
	/**
	 * 功能:销毁job信息
	 * 逻辑:
	 */
	public void destoryJobInfo();
	
	
}
