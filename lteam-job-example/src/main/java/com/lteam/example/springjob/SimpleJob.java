package com.lteam.example.springjob;

import java.util.Date;

import com.lteam.job.core.api.AbstractJob;

/**
 * @Description:任务定义
 * @author guicheng.huang
 * @date: 2017年4月24日 下午3:41:41
 * @version V0.0.1
 */
public class SimpleJob extends AbstractJob{

	@Override
	public void execute() {
		System.out.println(new Date());
	}

	
}
