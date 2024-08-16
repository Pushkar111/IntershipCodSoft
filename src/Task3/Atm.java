package Task3;

public class Atm
{
	private BankAccount account;

	public Atm(BankAccount account)
	{
		this.account = account;
	}

	public void withdraw(double amount)
	{
		try
		{
			account.withdraw(amount);
			System.out.println("Withdrawal successful. New balance : " + account.getBalance());
		} catch (InsufficientBalanceException e)
		{
			System.out.println("Error : " + e.getMessage());
		}
	}

	public void deposit(double amount)
	{
		account.deposit(amount);
		System.out.println("Deposit successful. New balance : " + account.getBalance());
	}

	public void checkBalance()
	{
		System.out.println("Current balance : " + account.getBalance());
	}

}