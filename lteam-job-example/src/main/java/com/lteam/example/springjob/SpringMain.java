package com.lteam.example.springjob;
import org.apache.log4j.Logger;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public final class SpringMain {
    
	private static final Logger logger =  Logger.getLogger(SpringMain.class);
	//手动启动配置文件
    public static void main(final String[] args) {
    	logger.info("加载job配置文件>> >> >>");
        new ClassPathXmlApplicationContext("classpath:spring/applicationContext-init.xml");
        try {
        	logger.info("设置当前时间睡眠>> >> >>");
			Thread.currentThread().sleep(100000l);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    }
}
