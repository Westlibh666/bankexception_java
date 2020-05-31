package Exception_account;

import java.util.Scanner;

public class Account {
	protected double balance;
	
	public Account(double init) {
		this.balance = init;
	}
	
	public double getBalance() {
		return balance;		
	}
	
	public void deposit(double amt) {
		this.balance += amt;
	}
	
	public void withdraw(double amt) throws OverdraftException{
		if(this.balance < amt) {
			throw new OverdraftException("余额不足", amt-this.balance);
		}
		this.balance -= amt;
	}

	public static void main(String[] args) {
		Account a = new Account(10000);
		@SuppressWarnings("resource")
		Scanner s = new Scanner(System.in);
		
		
		
		a.deposit(5000);		
		
		System.out.println(a.getBalance());
		
		try {
			System.out.println("请输入要取的金额：");
			double num = s.nextDouble();
			a.withdraw(num);
			System.out.println(a.getBalance());
		} catch (OverdraftException e) {
			System.out.println("透支金额："+e.getDefict());
			e.printStackTrace();// TODO: handle exception
		}
	}
	
}
