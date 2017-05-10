package com.lteam.job.core.service.version;
import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Test;
import com.lteam.job.common.version.VersionConfig;
import com.lteam.job.core.config.version.VersionNode;
import com.lteam.job.core.register.impl.ZkRegisterCenter;
import com.lteam.job.core.service.common.JobCommon;
import com.lteam.job.core.service.common.ZkRegisterCenterCommon;
import com.lteam.job.core.service.version.impl.ZkJobVersionServiceImpl;

/**
 * @Description:
 * @author guicheng.huang
 * @date: 2017年5月10日 上午10:43:22
 * @version V0.0.1
 */
public class VersionServiceTest {
	
	private static final Logger logger =  Logger.getLogger(VersionServiceTest.class);
	
	static{
		//初始化连接配置
		ZkRegisterCenter.setCenterConfig(ZkRegisterCenterCommon.getRegisterCenterConfig());
	}
	
	IJobVersionService service = new ZkJobVersionServiceImpl();
	
	
//	@Test
//	public void getJobVersionList(){
//		List<VersionConfig> list  =  service.addVersionInfo(new VersionNode().addVersionInfo(JobCommon.getJobConfig())).getJobVersionList();
//	    for (VersionConfig versionConfig : list) {
//	    	logger.info(versionConfig.getVersion()+":"+versionConfig.getJobConfig().toString());
//		}
//	}
//	
//	@Test
//	public void getJobVersion(){
//		VersionConfig config = service.addVersionInfo(new VersionNode().addVersionInfo(JobCommon.getJobConfig())).getJobVersion("20170510133253-36187");
//		logger.info(config!=null?config.toString():"");
//	}
//	
//	@Test
//	public void getJobVersionNum(){
//		int num = service.addVersionInfo(new VersionNode().addVersionInfo(JobCommon.getJobConfig())).getJobVersionNum();
//		logger.info(num);
//	} 
//	
//	@Test
//	public void getCurrentVersion() {
//		VersionConfig config = service.addVersionInfo(new VersionNode().addVersionInfo(JobCommon.getJobConfig())).getCurrentVersion();
//		logger.info("current"+config.toString());
//	}
//	
//	@Test
//	public void storeVersionInfo(){
//		VersionNode node = new VersionNode().addVersionInfo(JobCommon.getJobConfig());
//		service.addVersionInfo(node).storeVersionInfo();
//		logger.info("存储版本成功");
//	}
//	
//	@Test
//	public void destoryVersionInfo() {
//		service.addVersionInfo(new VersionNode().addVersionInfo(JobCommon.getJobConfig())).destoryVersionInfo("20170510154742-17652");
//		logger.info("删除版本成功");
//	}
	
//	@Test
//	public void destoryBestOldVersionInfo(){
//		service.addVersionInfo(new VersionNode().addVersionInfo(JobCommon.getJobConfig())).destoryBestOldVersionInfo();
//		logger.info("删除最老版本成功");
//	}
}
