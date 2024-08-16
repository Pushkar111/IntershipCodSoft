package Task3;

public class BankAccount
{
	private double bal;

	public BankAccount(double bal)
	{
		this.bal = bal;
	}

	public double getBalance()
	{
		return bal;
	}

	public void deposit(double amount)
	{
		bal += amount;
	}

	public void withdraw(double amount) throws InsufficientBalanceException
	{
		if (amount > bal)
		{
			throw new InsufficientBalanceException("Insufficient balance");
		}
		bal -= amount;
	}
}
