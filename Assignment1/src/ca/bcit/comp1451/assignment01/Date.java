/**
 * 
 */
package ca.bcit.comp1451.assignment01;

import java.util.HashMap;

/**
 * @author Rain
 *
 */
public class Date {
	public static final int MIN_DAY = 1;
	public static final int MAX_DAY = 31;
	public static final int MIN_MONTH = 1;
	public static final int MAX_MONTH = 12;
	public static final int MIN_YEAR = 1900;
	public static final int MAX_YEAR = 2019;
	public static final int SEP = 9;

	private int day;
	private int month;
	private int year;
	private HashMap<Integer, String> monthNames;

	/**
	 * @param day
	 * @param month
	 * @param year
	 */
	public Date(int day, int month, int year) {
		setDay(day);
		setMonth(month);
		setYear(year);
		monthNames = new HashMap<Integer, String>();
		populateHashMap();
	}

	/**
	 * @return the day
	 */
	public int getDay() {
		return day;
	}

	/**
	 * @param day the day to set
	 */
	public void setDay(int day) {
		if (day >= MIN_DAY && day <= MAX_DAY) {
			this.day = day;
		} else {
			this.day = MIN_DAY;
		}
	}

	/**
	 * @return the month
	 */
	public int getMonth() {
		return month;
	}

	/**
	 * @param month the month to set
	 */
	public void setMonth(int month) {
		if (month >= MIN_MONTH && month <= MAX_MONTH) {
			this.month = month;
		} else {
			this.month = MIN_MONTH;
		}
	}

	/**
	 * @return the year
	 */
	public int getYear() {
		return year;
	}

	/**
	 * @param year the year to set
	 */
	public void setYear(int year) {
		if (year >= MIN_YEAR && year <= MAX_YEAR) {
			this.year = year;
		} else {
			this.year = MIN_YEAR;
		}
	}

	/**
	 * method to load hash map with months names and numbers
	 */
	private void populateHashMap() {
		monthNames.put(1, "January");
		monthNames.put(2, "February");
		monthNames.put(3, "March");
		monthNames.put(4, "April");
		monthNames.put(5, "May");
		monthNames.put(6, "June");
		monthNames.put(7, "July");
		monthNames.put(8, "August");
		monthNames.put(9, "September");
		monthNames.put(10, "October");
		monthNames.put(11, "November");
		monthNames.put(12, "December");
	}

	/**
	 * @param year the year to set
	 */
	public String getDateFormat() {
		if (this.day <= SEP) {
			return "0" + getDay() + "/" + monthNames.get(month) + "/" + getYear();
		} else {
			return getDay() + "/" + monthNames.get(month) + "/" + getYear();
		}
	}

}
