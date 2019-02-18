/**
 * 
 */
package ca.bcit.comp1451.assignment01;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.Scanner;

/**
 * @author Rain
 *
 */
public class Bank {
	private String bankName;
	private HashMap<String, Account> accountObject;

	/**
	 * @param bankName
	 */
	public Bank(String bankName) {
		setBankName(bankName);

		accountObject = new HashMap<String, Account>();
	}

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		if (bankName != null & bankName.length() > 0) {
			this.bankName = bankName;
		} else {
			throw new IllegalArgumentException("bank name cannot be null or empty");
		}
	}

	/**
	 * @param toadd the account added
	 */
	public void addAccount(Account toadd) {
		 String accKey = toadd.getAccountNumber();
		 if(accountObject.containsKey(accKey)) {
				System.out.println("key already exists in the map");
			} else {
				accountObject.put(accKey, toadd);
			}
	}

	/**
	 * @param accountNumber
	 * @return an account
	 */
	public Account getAccount(String accountNumber) {
		if(accountNumber == null) {
			throw new IllegalArgumentException("account number cannot be null");
		} else if(!accountObject.containsKey(accountNumber)) {
			System.out.println("account number cannot be found");
		}
		return accountObject.get(accountNumber);
	}

	/**
	 * @param name the name of the customer method to display customer's account
	 *             details
	 */
	public void showTransactions(String name) {
		Set<Map.Entry<String, Account>> theSet = accountObject.entrySet();
		for (Map.Entry<String, Account> s : theSet) {
			if (s.getValue().getCustomer().getName().equalsIgnoreCase(name)) {
				Account a = s.getValue();
				a.displayAccountInfo();
				a.displayTransactionRecord();
			}
		}
	}

	/**
	 * method to display all the bank account numbers
	 */
	public void displayAccountNumbers() {
		Set<String> myKeySet = accountObject.keySet();
		for (String key : myKeySet) {
			System.out.println(key);
		}
	}

	/**
	 * method to make a transaction
	 */
	public void makeTransaction() {

		Scanner input = new Scanner(System.in);
		System.out.println("Enter your account number: ");

		String userAcc = input.next();
		String option = "";
		String answer = "";
		if (accountObject.containsKey(userAcc)) {

			System.out.println("1. Deposit");
			System.out.println("2. Withdraw");
			System.out.println("3. Show Transactions");
			System.out.println();

			do {
				System.out.println("Choose one");
				option = input.next();
				System.out.println();

				switch (option) {

				case "1":
					System.out.println("please enter the amount");
					double amount1 = input.nextDouble();
					if (accountObject.get(userAcc).deposit(amount1) == true) {
						System.out.println("please enter a day a month and a year");
						int day = input.nextInt();
						int month = input.nextInt();
						int year = input.nextInt();
						Date date = new Date(day, month, year);
						TransactionRecord transRecord = new TransactionRecord(amount1, date, userAcc, "deposit");
						accountObject.get(userAcc).addTransaction(transRecord);
					}
					break;

				case "2":
					System.out.println("please enter the amount");
					double amount2 = input.nextDouble();
					if (accountObject.get(userAcc).withdraw(amount2) == true) {
						System.out.println("please enter a day a month and a year");
						int day = input.nextInt();
						int month = input.nextInt();
						int year = input.nextInt();
						Date date = new Date(day, month, year);
						TransactionRecord transRecord = new TransactionRecord(amount2, date, userAcc, "withdraw");
						accountObject.get(userAcc).addTransaction(transRecord);
					}
					break;

				case "3":
					System.out.println("please enter user name");
					String name = input.next();
					showTransactions(name);
					break;

				default:
					System.out.println("invalid number. please choose again");
					break;
				}

				System.out.println("do you want to make another transaction?");
				answer = input.next();

			} while (answer.equalsIgnoreCase("yes"));

		} else {
		System.out.println("Account number not found");
		}
		System.out.println("Thank you");
	}
}
