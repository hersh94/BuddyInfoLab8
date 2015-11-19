import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


public class BuddyInfoTest {
	private BuddyInfo legalBuddy = null;
	private BuddyInfo compareBuddy = null;
	
	@Before
	public void setUp(){
		legalBuddy = new BuddyInfo("Josh", "8833921", "44 Street", 21);
		compareBuddy = new BuddyInfo("Josh", "8833921", "44 Street", 21);
	}
	
	@Test
	public void testGreeting() {
		assertEquals("Greeting should be hi", "hi", legalBuddy.greeting());
	}
	@Test
	public void testGetAge() {
		assertEquals("Age should be 21", 21, legalBuddy.getAge());
	}
	@Test
	public void testSetAge() {
		legalBuddy.setAge(10);
		assertEquals("Age should be 10", 10, legalBuddy.getAge());
	}
	@Test
	public void testIsOver18() {
		assertEquals("Should be true", true, legalBuddy.isOver18());
	}
	@Test
	public void testGetName() {
		assertEquals("Name should be Josh", "Josh", legalBuddy.getName());
	}
	@Test
	public void testSetName() {
		legalBuddy.setName("Paul");
		assertEquals("Name should be Paul", "Paul", legalBuddy.getName());
	}
	@Test
	public void testGetAddress() {
		assertEquals("Address Should Be 44 Street", "44 Street", legalBuddy.getAddress());
	}
	@Test
	public void testGetNumber() {
		assertEquals("Number should be 8833921", "8833921", legalBuddy.getNumber());
	}
	@Test
	public void testSetNumber() {
		legalBuddy.setNumber("1234567");
		assertEquals("Number should be 1234567", "1234567", legalBuddy.getNumber());
	}
	@Test
	public void testSetAddress() {
		legalBuddy.setAddress("Hi Street");
		assertEquals("Address Should Be Hi Street", "Hi Street", legalBuddy.getAddress());
	}
	@Test
	public void testToString() {
		assertEquals("long string...","Name: Josh Number: 8833921 Address: 44 Street",legalBuddy.toString());
	}
	@Test
	public void testEqualsObject() {
		assertEquals("Buddies should be the same", true, legalBuddy.equals(compareBuddy));
	}

}
