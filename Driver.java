/**
 * 
 */
package ca.bcit.comp1451.assignment01;

/**
 * @author Rain
 *
 */
public class Driver {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Customer customer1 = new Customer("Bob", "123 No.1 St", "1990.11.03");
		Customer customer2 = new Customer("Tiger", "456 No.2 St", "1992.02.14");
		Customer customer3 = new Customer("James", "789 No.3 St", "1994.09.23");
		Customer customer4 = new Customer("Jane", "111 No.4 St", "1996.05.17");

		Date date1 = new Date(12, 12, 2013);
		Date date2 = new Date(2, 4, 2010);
		Date date3 = new Date(17, 24, 2009);
		Date date4 = new Date(1, 9, 2016);

		Account account1 = new Account(customer1, date1, 123.5);
		Account account2 = new Account(customer2, date2, 298.7);
		Account account3 = new Account(customer3, date3, 98.4);
		Account account4 = new Account(customer4, date4, 200.5);

		Bank bank = new Bank("TD");
		bank.addAccount(account1);
		bank.addAccount(account2);
		bank.addAccount(account3);
		bank.addAccount(account4);

		bank.displayAccountNumbers();
		bank.makeTransaction();
	}

}
