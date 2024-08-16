package Task1;

import java.util.Random;
import java.util.Scanner;

public class GuessRandomNoGame
{
	private static final int MAX_ATTEMPS = 10;
	private static final int MAX_NUMBER = 100;
	private static final Random r = new Random();
	private static final Scanner sc = new Scanner(System.in);

	public static void main(String[] args)
	{
		int score = 0;
		int noOfRounds = 0;

		while (true)
		{
			int noToGuess = generateRandomNo();
			int attemps = playRound(noToGuess);

			if (attemps > 0)
			{
				score += MAX_ATTEMPS - attemps + 1;
				noOfRounds++;
			}

			if (!playAgain())
			{
				break;
			}

		}

		showFinalScore(score, noOfRounds);

	}

	private static int generateRandomNo()
	{
		return r.nextInt(MAX_NUMBER) + 1;
	}

	private static int playRound(int noToGuess)
	{
		int attemps = 0;

		System.out.println("=======================================================");
		System.out.println("				Welcome to Guess No Game			   ");
		System.out.println("=======================================================");

		System.out.println("You have Maximum " + MAX_ATTEMPS + " attemps to Guess Random No");

		while (attemps < MAX_ATTEMPS)
		{
			int no = getGuess();
			attemps++;

			if (no < noToGuess)
			{
				System.out.println("Low No :: Try Again !");
			} else if (no > noToGuess)
			{
				System.out.println("High No :: Try Again !");
			} else
			{
				System.out.println("Congratulations! You guessed the number in " + attemps + " attempts.");
				return attemps;
			}
		}

		System.out.println("You didn't guess the number. The number was " + noToGuess + ".");
		return 0;

	}

	private static int getGuess()
	{
		while (true)
		{
			try
			{
				System.out.println("Enter No : ");
				return sc.nextInt();
			} catch (Exception e)
			{
				System.out.println("Invalid input. Please enter a number.");
				sc.next();
			}
		}
	}

	private static boolean playAgain()
	{
		System.out.println("Do You Wants to Play Again ? (Yes/No) : ");
		String reply = sc.next();

		if (reply.equalsIgnoreCase("Yes") || reply.equalsIgnoreCase("yes"))
		{
			return true;
		} else if (reply.equalsIgnoreCase("No") || reply.equalsIgnoreCase("no"))
		{
			return false;
		} else
		{
			System.out.println("Invalid input. Please enter 'yes' or 'no'.");
		}
		return false;
	}

	private static void showFinalScore(int score, int NoOfRounds)
	{
		System.out.println("You played " + NoOfRounds + " rounds and scored " + score + " points.");
	}
}
