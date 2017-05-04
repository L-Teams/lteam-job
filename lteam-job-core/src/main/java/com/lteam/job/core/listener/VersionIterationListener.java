package com.lteam.job.core.listener;
import com.lteam.job.common.zkServer.listener.AbstractZkNodeListener;
/**
 * @Description:版本迭代监听
 *             :job配置信息修改时触发
 * @author guicheng.huang
 * @date: 2017年4月28日 上午10:28:04
 * @version V0.0.1
 */
public class VersionIterationListener extends AbstractZkNodeListener {

	
	public void nodeChanged() throws Exception {
	
		System.out.println(super.cache.getCurrentData().getData());
	}

}
