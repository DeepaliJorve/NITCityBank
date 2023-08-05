package com.gs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import com.gs.service.IBankMgmtService;

@SpringBootApplication
public class TxMgmtProj04BootLocalTxMgmtSpringJdbcApplication {

	public static void main(String[] args) {
		//create IOC container
		ApplicationContext ctx=SpringApplication.run(TxMgmtProj04BootLocalTxMgmtSpringJdbcApplication.class, args);
	
		//get service class object
	    IBankMgmtService proxy=ctx.getBean("bankService",IBankMgmtService.class);
	    //invoke methods
	    try {
	    	System.out.println(proxy.transferMoney(1009, 1001, 5000.0));
	    }catch(Exception e) {
	    	e.printStackTrace();
	    }
	    //close container
	    ((ConfigurableApplicationContext) ctx).close();
	    
	}

}
