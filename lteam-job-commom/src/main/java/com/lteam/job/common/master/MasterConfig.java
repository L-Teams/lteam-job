package com.lteam.job.common.master;

import com.lteam.job.common.routing.RoutingStrategy;
import com.lteam.job.common.server.ServerConfig;

/**
 * @Description:主节点配置
 * @author guicheng.huang
 * @date: 2017年4月19日 上午10:31:16
 * @version V0.0.1
 */
public class MasterConfig extends ServerConfig{

	private RoutingStrategy rouingType = RoutingStrategy.FAILOVER;
	
    private String logInterFace; //日志服务地址
    
	public String getLogInterFace() {
		return logInterFace;
	}

	public void setLogInterFace(String logInterFace) {
		this.logInterFace = logInterFace;
	}

	public RoutingStrategy getRouingType() {
		return rouingType;
	}

	public void setRouingType(RoutingStrategy rouingType) {
		this.rouingType = rouingType;
	}
	
}
