package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entities.Account;
import model.exception.DomainException;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<Account> list = new ArrayList<>();

		System.out.println("Enter account data:");
		System.out.print("Number:");
		int numAcc = sc.nextInt();
		System.out.print("Holder:");
		sc.nextLine();
		String holder = sc.nextLine();
		System.out.print("Initial balance:");
		Double inicialBalance = sc.nextDouble();
		System.out.print("Withdraw limit:");
		Double withdrawLimit = sc.nextDouble();

		Account account = new Account(numAcc, holder, inicialBalance, withdrawLimit);
		list.add(account);

		System.out.println(" ");
		System.out.print("Enter amount for withdraw:");
		Double withdrawValue = sc.nextDouble();

		try {
			account.withdraw(withdrawValue);
			System.out.println("New balance:"+ String.format("%.2f", account.getBalance()));
		} catch (DomainException e) {
			System.out.println("Window error: " + e.getMessage());
		}

		sc.close();

	}

}
