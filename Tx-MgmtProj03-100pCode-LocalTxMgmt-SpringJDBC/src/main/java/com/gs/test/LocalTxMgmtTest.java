package com.gs.test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.gs.config.AppConfig;
import com.gs.service.IBankMgmtService;

public class LocalTxMgmtTest {

	public static void main(String[] args) {
		
	
	//create IOC container
	AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
	//get service class object
	IBankMgmtService proxy=ctx.getBean("bankService", IBankMgmtService.class);
	//invoke method
	try {
		System.out.println(proxy.transferMoney(1009, 1002, 5000.0));
	}
	catch(Exception e) {
		e.printStackTrace();
	}
	//close container
	ctx.close();
}
}