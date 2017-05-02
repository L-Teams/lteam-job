package com.lteam.example.springjob;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public final class SpringMain {
    
	//手动启动配置文件
    public static void main(final String[] args) {
        new ClassPathXmlApplicationContext("classpath:spring/applicationContext-init.xml");
    }
}
