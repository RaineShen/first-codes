/**
 * 
 */
package ca.bcit.comp1451.assignment01;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * @author Rain
 *
 */
public class Account {
	private static int num = 1000;
	
	private Customer customer;
	private String accountNumber;
	private Date dateAccountCreated;
	private double balance;
	private ArrayList<TransactionRecord> record;
	
	/**
	 * @param customer
	 * @param dateAccountCreated
	 * @param balance
	 */
	public Account(Customer customer, Date dateAccountCreated, double balance) {
		setCustomer(customer);
		setDateAccountCreated(dateAccountCreated);
		setBalance(balance);
		
		record = new ArrayList<TransactionRecord>();
		createAccountNumber(); 
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the dateAccountCreated
	 */
	public Date getDateAccountCreated() {
		return dateAccountCreated;
	}

	/**
	 * @param dateAccountCreated the dateAccountCreated to set
	 */
	public void setDateAccountCreated(Date dateAccountCreated) {
		this.dateAccountCreated = dateAccountCreated;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the record
	 */
	public ArrayList<TransactionRecord> getRecord() {
		return record;
	}

	/**
	 * @param record the record to set
	 */
	public void setRecord(ArrayList<TransactionRecord> record) {
		this.record = record;
	}
	
	/**
	 * method to create a unique account number
	 */
	private void createAccountNumber() {
		accountNumber = "" + num;
		num++;
	}

	/**
	 * method to check deposit amount
	 */
	public boolean deposit(double amount) {
		boolean deposit;
		if(amount >= 0) {
			deposit = true;
			this.balance = balance + amount;
		} else {
			deposit = false;
			System.out.println("the deposit amount is invalid");
		}
		return deposit;
	}
	
	/**
	 * method to check withdraw amount
	 */
	public boolean withdraw(double amount) {
		boolean withdraw;
		if(amount >= 0 && amount <= this.balance) {
			withdraw = true;
			this.balance = balance - amount;
		} else {
			withdraw = false;
			System.out.println("the withdraw amount is invalid");
		}
		return withdraw;
	}
	
	/**
	 * method to add a Transaction object to the arrayList
	 */
	public void addTransaction(TransactionRecord transRecord) {
		if(transRecord != null) {
		record.add(transRecord);
		}
	}
	
	/**
	 * method to display the info of transaction record
	 */
	public void displayTransactionRecord() {
		Iterator<TransactionRecord> it = record.iterator();

        while(it.hasNext()) {
        	TransactionRecord transInfo = it.next();
        	System.out.println("The account number is " + transInfo.getAccountNumber());
        	System.out.println("the date issued is " + transInfo.getDateIssued().getDateFormat());
        	System.out.println("the transaction amount is " + transInfo.getAmount());
        	System.out.println("the transaction type is " + transInfo.getTransactionType());
        }
	}
	
	/**
	 * method to display account info
	 */
	public void displayAccountInfo() {
		System.out.println("Customer name is " + customer.getName());
		System.out.println("Account number is " + getAccountNumber());
		System.out.println("The balance is " + getBalance());
		System.out.println("Date created is " + dateAccountCreated.getDateFormat());
	}
}
