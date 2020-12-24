package com.lec.ex08_account;

public class AccountMain {

	public static void main(String[] args) {
	
		Account a1 = new Account("111-1111", "»´±Êµø");
		CheckingAccount a2 = new CheckingAccount("222-2222", "º∫√·«‚", 2000, "1234-1234-1234-1323");
		CheckingAccount a3 = new CreditLineAccount("333-2222", "¿Ã√·«‚", 2000, "1234-1234-0000-9999",10000);
		
		a1.deposit(3000);
		a2.withdraw(200);
		a3.deposit(3000);
		
		a1.printAccount();
		a2.pay("1234-1234-1234-1323", 200);
		a3.pay("1234-1234-1234-1323", 5000);
	
	}

}
