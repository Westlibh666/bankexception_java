package Exception_account;

public class CheckingAccount extends Account{
	private double overdrafProtection;
	
	public CheckingAccount(double balance) {
		super(balance);
		// TODO 自动生成的构造函数存根
	}

	public CheckingAccount(double balance,double overdrafProtection) {
		super(balance);
		this.overdrafProtection = overdrafProtection;
	}
	
	public void withdraw(double amt) throws OverdraftException{
		if(amt > this.balance + overdrafProtection) {
			double deficit = amt - (this.balance + overdrafProtection);
			throw new OverdraftException("透支额度超标", deficit);
		}
		this.balance -= amt;
	}
	
	public static void main(String[] args) {
		CheckingAccount a = new CheckingAccount(10000,5000);
		a.deposit(5000);
		System.out.println(a.getBalance());
		
		try {
			a.withdraw(5000);
			System.out.println(a.getBalance());
			a.withdraw(5000);
			System.out.println(a.getBalance());
			a.withdraw(5000);
			System.out.println(a.getBalance());
			a.withdraw(5000);
			System.out.println(a.getBalance());
			a.withdraw(5000);
			System.out.println(a.getBalance());
		} catch (OverdraftException e) {
			System.err.println("透支超额："+e.getDefict());// TODO: handle exception
		}
	
}
}

