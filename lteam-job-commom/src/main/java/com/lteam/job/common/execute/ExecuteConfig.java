package com.lteam.job.common.execute;

import com.lteam.job.common.config.Config;
import com.lteam.job.common.util.SilenceJobIdFactory;

/**
 * @Description:执行器配置
 * @author guicheng.huang
 * @date: 2017年4月21日 下午6:14:59
 * @version V0.0.1
 */
public class ExecuteConfig extends Config{

	private String silenceJobName;

	public String getSilenceJobName() {
		silenceJobName = jobName + SilenceJobIdFactory.getSilenceJobId(jobName);
		return silenceJobName;
	}

	public void setSilenceJobName(String silenceJobName) {
		this.silenceJobName = silenceJobName;
	}
	
}
