package com.gs.service;

public interface IBankMgmtService {

	public String transferMoney(int srcAcno, int descAcno, double amount) throws IllegalAccessException;
}
