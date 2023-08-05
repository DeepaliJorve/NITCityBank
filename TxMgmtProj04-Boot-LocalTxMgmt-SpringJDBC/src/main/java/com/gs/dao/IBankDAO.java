package com.gs.dao;

public interface IBankDAO {

	public int withdraw(int accno, Double amount);
	public int deposite(int accno, Double amount);
}
