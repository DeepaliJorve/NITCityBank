package com.gs.service;

public interface IBankMgmtService {

	public String transferMoney(int descAcno, int srcAcno, double amount)throws IllegalAccessException;
}
