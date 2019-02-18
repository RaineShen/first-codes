/**
 * 
 */
package ca.bcit.comp1451.assignment01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * @author Rain
 *
 */
class DateTest {
	private Date date1;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * test day
	 */
	@Test
	public void testConstructorDayNegative() {
		Date date = new Date(-1,1,2018);
		assertEquals(1, date.getDay());
	}

	@Test
	public void testConstructorDayPositive() {
		Date date = new Date(12,1,2018);
		assertEquals(12, date.getDay());
	}
	
	@Test
	void testConstructorDayBoundary0() {
		Date date = new Date(0,1,2018);
		assertEquals(1, date.getDay());
	}
	
	/**
	 * test month
	 */
	@Test
	public void testConstructorMonthNegative() {
		Date date = new Date(1,-1,2018);
		assertEquals(1, date.getMonth());
	}

	@Test
	public void testConstructorMonthPositive() {
		Date date = new Date(1,10,2018);
		assertEquals(10, date.getMonth());
	}
	
	@Test
	void testConstructorMonthBoundary0() {
		Date date = new Date(1,0,2018);
		assertEquals(1, date.getMonth());
	}

	/**
	 * test year
	 */
	@Test
	public void testConstructorYearNegative() {
		Date date = new Date(1,1,-1);
		assertEquals(1900, date.getYear());
	}

	@Test
	public void testConstructorYearPositive() {
		Date date = new Date(1,10,2018);
		assertEquals(2018, date.getYear());
	}
	
	@Test
	void testConstructorYearBoundary1899() {
		Date date = new Date(1,1,1899);
		assertEquals(1900, date.getYear());
	}
	
	@Test
	void testConstructorYearBoundary2020() {
		Date date = new Date(1,1,2020);
		assertEquals(1900, date.getYear());
	}
}
