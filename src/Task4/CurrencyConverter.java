package Task4;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CurrencyConverter
{

	private static final String API_KEY = "43bdb5cfc0624ebffb2845ae";
	private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/pair/";

	public static void main(String[] args) throws IOException, InterruptedException
	{

		Scanner sc = new Scanner(System.in);

		String baseCurrency = getCurrencyInput(sc, "Select base currency (e.g. USD, EUR, JPY):");
		String targetCurrency = getCurrencyInput(sc, "Select target currency (e.g. USD, EUR, JPY):");
		double amount = getAmountInput(sc, "Enter amount to convert:");

		double response = getExchangeRate(baseCurrency, targetCurrency);

		if (response != 0)
		{
			double exchangeRate = response;
			double convertedAmount = amount * exchangeRate;

			System.out.println("1 " + baseCurrency + " = " + exchangeRate + " " + targetCurrency);
			System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
		} else
		{
			System.out.println("Failed to fetch exchange rate.");
		}
	}

	private static String getCurrencyInput(Scanner scanner, String prompt)
	{
		while (true)
		{
			try
			{
				System.out.println(prompt);
				String currency = scanner.next().toUpperCase();
				if (currency.length() != 3)
				{
					System.out.println("Invalid currency code. Please enter a 3-letter code (e.g. USD, EUR, JPY).");
				} else
				{
					return currency;
				}
			} catch (Exception e)
			{
				System.out.println("Invalid input. Please try again.");
				scanner.next(); // Clear invalid input
			}
		}
	}

	private static double getAmountInput(Scanner scanner, String prompt)
	{
		while (true)
		{
			try
			{
				System.out.println(prompt);
				return scanner.nextDouble();
			} catch (InputMismatchException e)
			{
				System.out.println("Invalid amount. Please enter a number.");
				scanner.next(); // Clear invalid input
			}
		}
	}

	private static double getExchangeRate(String baseCurrency, String targetCurrency)
			throws IOException, InterruptedException
	{
		HttpClient client = HttpClient.newHttpClient();
		String url = API_URL + baseCurrency + "/" + targetCurrency;
		HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).GET().build();

		try
		{
			HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
			if (response.statusCode() == 200)
			{
				String responseBody = response.body();
				// Manual parsing to extract conversion rate
				int startIndex = responseBody.indexOf("conversion_rate") + 17;
				int endIndex = responseBody.indexOf(",", startIndex);
				if (endIndex == -1)
				{
					endIndex = responseBody.indexOf("}", startIndex);
				}
				if (startIndex > 16 && endIndex > startIndex)
				{
					String rateString = responseBody.substring(startIndex, endIndex);
					return Double.parseDouble(rateString);
				} else
				{
					System.out.println("Conversion rate not found in response.");
					return -1; // Indicate an error
				}
			} else
			{
				System.out.println("API error: " + response.statusCode());
				return -1; // Indicate an error
			}
		} catch (IOException | InterruptedException e)
		{
			System.out.println("Error fetching exchange rate: " + e.getMessage());
			return -1; // Indicate an error
		}
	}

}
