package com.lteam.job.core.service.config.impl;
import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import com.lteam.job.common.config.NodePath;
import com.lteam.job.common.job.JobConfig;
import com.lteam.job.common.zkServer.IZookeeperCilentApi;
import com.lteam.job.core.config.config.ConfigNode;
import com.lteam.job.core.register.impl.ZkRegisterCenter;
import com.lteam.job.core.service.config.IJobConfigService;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年4月26日 下午3:11:54
 * @version V0.0.1
 */
public class ZkJobConfigServiceImpl implements IJobConfigService{

	private ConfigNode configNode;
	
	private static CuratorFramework cilent = null ; 
	
	@Autowired
	private IZookeeperCilentApi zkApi;
	
	static {
		if(cilent == null){
			cilent = ZkRegisterCenter.getCilent();
		}
	}
	
	public IJobConfigService addJobConfigInfo(JobConfig config){
		this.configNode = new ConfigNode().addJobInfo(config);
		return this;
	}
	
	//TODO -> Exception 自定义处理
	//     -> 版本信息处理
	public void handleJobInfo(){
		try {
            if(cilent.checkExists().forPath(configNode.getNodePath()) != null){
               cilent.create()
				     .creatingParentsIfNeeded()
				     .forPath(configNode.getNodePath(), configNode.getNodeContent().getBytes());
               Stat stat = new Stat();
               cilent.getData().storingStatIn(stat).forPath(configNode.getNodePath());
               
            }else{
            	
            }
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void destoryJobInfo(){
		try {
			cilent.delete()
			      .deletingChildrenIfNeeded()
			      .forPath(NodePath.getJobPath(configNode.getJobInfo()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public IJobConfigService addJobConfigInfo(ConfigNode config) {
		return null;
	}
}
