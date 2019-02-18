/**
 * 
 */
package ca.bcit.comp1451.assignment01;

/**
 * @author Rain
 *
 */
public class Customer {

	private String name;
	private String address;
	private String dateOfBirth;

	/**
	 * @param name
	 * @param address
	 * @param dateOfBirth
	 */
	public Customer(String name, String address, String dateOfBirth) {
		setName(name);
		setAddress(address);
		setDateOfBirth(dateOfBirth);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		if (name != null && name.length() > 0) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("name cannot be null or empty");
		}
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		if (address != null && address.length() > 0) {
			this.address = address;
		} else {
			throw new IllegalArgumentException("address cannot be null or empty");
		}
	}

	/**
	 * @return the dateOfBirth
	 */
	public String getDateOfBirth() {
		return dateOfBirth;
	}

	/**
	 * @param dateOfBirth the dateOfBirth to set
	 */
	public void setDateOfBirth(String dateOfBirth) {
		if (dateOfBirth != null && dateOfBirth.length() > 0) {
			this.dateOfBirth = dateOfBirth;
		} else {
			throw new IllegalArgumentException("date of birth cannot be null or empty");
		}
	}
	
	/**
	 * @return a formatted name
	 */
	public String formatName(String word) {
		String formatName = word.substring(0, 1).toUpperCase() + word.substring(1).toLowerCase();
		return formatName;
	}
	
	/**
	 * method to display all info of customer
	 */
	public void displayCustomer() {
		String customerName = formatName(getName());
		System.out.println("Customer's name is " + customerName);
		System.out.println("and address is " + getAddress());
		System.out.println("and date of birth is " + getDateOfBirth());
	}
}
