import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class AddressBookTest {
	private AddressBook addressB = null;
	private BuddyInfo uselessBuddy = null;
	@Before
	public void setUp(){
		addressB = new AddressBook();
		uselessBuddy = new BuddyInfo("Joe", "11111", "Street", 50);
	}
	
	@Test
	public void testAddBuddy() {
		addressB.addBuddy(uselessBuddy);
		assertEquals("Should be 1 buddy",true, addressB.contains(uselessBuddy));
	}
	@Test
	public void testRemoveBuddy() {
		addressB.addBuddy(uselessBuddy);
		addressB.removeBuddy("Joe");
		assertEquals("Should be 1 buddy",false, addressB.contains(uselessBuddy));
	}
	@Test
	public void testEditBuddy() {
		addressB.addBuddy(uselessBuddy);
		addressB.editBuddy("Joe", "John");
		assertEquals("Should be new named buddy John", "John", addressB.getBuddy("John").getName());
	}
	@Test
	public void testSize() {
		addressB.addBuddy(uselessBuddy);
		assertEquals("Should be 1 buddy",1, addressB.size());
	}
	@Test
	public void testClear() {
		addressB.addBuddy(uselessBuddy);
		addressB.clear();
		assertEquals("Should be empty list", 0, addressB.size());
	}
	@Test
	public void testGetBuddies() {
		addressB.addBuddy(uselessBuddy);
		assertEquals("Should be buddy John", uselessBuddy, addressB.getBuddy("Joe"));
	}

}
