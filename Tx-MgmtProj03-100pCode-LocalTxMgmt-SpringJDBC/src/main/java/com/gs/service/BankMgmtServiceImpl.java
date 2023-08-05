package com.gs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.gs.dao.IBankDAO;

@Service("bankService")
public class BankMgmtServiceImpl implements IBankMgmtService {

	@Autowired
	private IBankDAO dao;
	
	@Override
	@Transactional(propagation=Propagation.REQUIRED,
	               rollbackFor=IllegalAccessException.class,
	               transactionManager="dsTxMgmr")
	public String transferMoney(int srcAcno, int descAcno, double amount) throws IllegalAccessException {
		int count1=dao.deposite(descAcno, amount);
		int count2=dao.withdraw(srcAcno, amount);
		
		if(count1==0||count2==0)
			throw new IllegalAccessException("Tx rolled back ---> Money is not Transfer");
		return "Tx committed.. Money Transfered";
	}

}
