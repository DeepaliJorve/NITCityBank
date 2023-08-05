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
	               transactionManager="transactionManager")
	public String transferMoney(int descAcno, int srcAcno, double amount) throws IllegalAccessException {
		int count1=dao.withdraw(srcAcno, amount);
		int count2=dao.deposite(descAcno, amount);

		if(count1==0||count2==0)
			throw new IllegalAccessException("Tx rolled back-->Money not Transfer");
		else 
		return "Tx Committed.. Money Transfered";
	}

}
