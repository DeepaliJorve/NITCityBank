package com.gs.dao;

public interface IBankDAO {

	public int withdraw(int accno, double amount);
	public int deposite(int accno, double amount);
}
