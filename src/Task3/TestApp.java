package Task3;

import java.util.Scanner;

public class TestApp
{
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);

		BankAccount account = new BankAccount(1000);
		Atm atm = new Atm(account);

		while (true)
		{
			System.out.println("======================================================");
			System.out.println("		Welcome to the ATM!					  ");
			System.out.println("======================================================");
			System.out.println("1. Withdraw");
			System.out.println("2. Deposit");
			System.out.println("3. Check Balance");
			System.out.println("4. Exit");
			System.out.println("======================================================");

			System.out.println("Enter Choice : ");
			int choice = sc.nextInt();

			switch (choice)
			{
			case 1:
				System.out.print("Enter amount to withdraw : ");
				double withdrawAmount = sc.nextDouble();
				atm.withdraw(withdrawAmount);
				break;

			case 2:
				System.out.print("Enter amount to deposit : ");
				double depositAmount = sc.nextDouble();
				atm.deposit(depositAmount);
				break;

			case 3:
				atm.checkBalance();
				break;

			case 4:
				try
				{
					Thread.sleep(500);
				} catch (InterruptedException e)
				{
					e.printStackTrace();
				}
				System.out.println("-=-=-=-=-=-=-=-=-=-close Application-=-=-=-=-=-=-=-=-=-");
				System.exit(0);
				break;

			default:
				System.out.println("Invalid choice. Please try again.");
				break;
			}
		}
	}
}
