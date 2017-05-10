package com.lteam.job.common.version.factory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @Description:版本号生产工厂
 * @author guicheng.huang
 * @date: 2017年5月2日 下午5:56:28
 * @version V0.0.1
 */
public class VersionNumFactory {
	
	/**
	 * 生成规则:当前日期 yyyy-MM-dd HH:ss:mm-随机5位数
	 * @return
	 */
	public static String creatVersionNum(){
		  Random random = new Random();
		  int rannum = (int) (random.nextDouble() * (99999 - 10000 + 1)) + 10000;// 获取5位随机数
		  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHssmm");
		  return simpleDateFormat.format(new Date())+"-"+rannum;
	}
}
