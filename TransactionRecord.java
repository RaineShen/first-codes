/**
 * 
 */
package ca.bcit.comp1451.assignment01;

/**
 * @author Rain
 *
 */
public class TransactionRecord {
	private double amount;
	private Date dateIssued;
	private String accountNumber;
	private String transactionType;

	/**
	 * @param amount
	 * @param dateIssued
	 * @param accountNumber
	 * @param transactionType
	 */
	public TransactionRecord(double amount, Date dateIssued, String accountNumber, String transactionType) {
		setAmount(amount);
		setDateIssued(dateIssued);
		setAccountNumber(accountNumber);
		setTransactionType(transactionType);
	}

	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		if (amount >= 0) {
			this.amount = amount;
		} else {
			throw new IllegalArgumentException("amount cannot be negative");
		}
	}

	/**
	 * @return the dateIssued
	 */
	public Date getDateIssued() {
		return dateIssued;
	}

	/**
	 * @param dateIssued the dateIssued to set
	 */
	public void setDateIssued(Date dateIssued) {
		if (dateIssued != null) {
			this.dateIssued = dateIssued;
		} else {
			throw new IllegalArgumentException("date issued cannot be null");
		}
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
		if (accountNumber != null && accountNumber.length() > 0) {
			this.accountNumber = accountNumber;
		} else {
			throw new IllegalArgumentException("account number cannot be null or empty");
		}
	}

	/**
	 * @return the transactionType
	 */
	public String getTransactionType() {
		return transactionType;
	}

	/**
	 * @param transactionType the transactionType to set
	 */
	public void setTransactionType(String transactionType) {
		if (transactionType.equals("withdraw") || transactionType.equals("deposit")) {
			this.transactionType = transactionType;
		} else {
			throw new IllegalArgumentException("transaction type can only be withdraw or deposit");
		}
	}

	/**
	 * method to display the a string of transaction info
	 */
	public void transactionInfo() {
		System.out.println(getAccountNumber()); 
		System.out.println(getTransactionType());
		System.out.println(getAmount());
		System.out.println(getDateIssued());
	}
}
