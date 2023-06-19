public class BankAccount
{
	private String name;
	private String accountNumber;
	private double balance;
	public static int bankAccountCounter = 0;

	public BankAccount(String name, String accountNumber, double balance){
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
		bankAccountCounter++;
	}

	public BankAccount(){
		name = "";
		accountNumber = "";
		balance = -1;
		bankAccountCounter++;
	}

	public String toString(){
		return "Name: " + this.name + "\nAccount Number: " + this.accountNumber + "\nBalance: " + this.balance;
	}
	public static int bankAccountCounter(){
		return bankAccountCounter;
	}

	public void withdrawl(double amount){
		if (this.balance >= amount)
			this.balance -= amount;
	}
	public void deposit (double amount){
		this.balance += amount;
	}

	public static void main(String[] args){
		BankAccount b1 = new BankAccount("Nikhil", "abc123", 12.34);
		System.out.println(b1.toString() + "\n");
		b1.withdrawl(8.13);
		System.out.println(b1.toString() + "\n");
		b1.deposit(346.98);
		System.out.println(b1.toString() + "\n");
		System.out.println(bankAccountCounter());
	}

}