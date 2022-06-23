package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;
import contactService.ContactService;

// Test class
class ContactServiceTest {
	// Test adding a single contact 
	@Test
	void testAddContact() {
		// Creating ContactService class object to call upon map 
		ContactService contacts = new ContactService();
		
		// Add contact to map 
		contacts.addContact("1", "Katie", "McNeil", "1112223344", "123 Qwerty St");
		
		// Make sure contact was successfully added 
		assertTrue(contacts.contacts.containsKey("1"));
	}
	
	// Test adding multiple contacts 
	@Test
	void testAddContacts() {
		// Creating ContactService class object to call upon map 
		ContactService contacts = new ContactService();
		
		// Add contacts to map 
		contacts.addContact("1", "Katie", "McNeil", "1112223344", "123 Qwerty St");
		contacts.addContact("2", "Molly", "Dog", "5556667788", "456 Abc Rd");
		contacts.addContact("3", "Ivan", "Cat", "9990001122", "789 Road St");
		
		// Make sure contacts were successfully added 
		assertTrue(contacts.contacts.containsKey("1"));
		assertTrue(contacts.contacts.containsKey("2"));
		assertTrue(contacts.contacts.containsKey("3"));
	}
	
	// Test to make sure unique IDs are being used
	@Test 
	void testUniqueID() {
		// Creating ContactService class object to call upon map 
		ContactService contacts = new ContactService();
		
		// Add contacts to map 
		contacts.addContact("1", "Katie", "McNeil", "1112223344", "123 Qwerty St");
		contacts.addContact("2", "Lola", "McGee", "5556667788", "456 Abc Rd");
		contacts.addContact("3", "Ivan", "Cat", "9990001122", "789 Road St");
		
		// Make sure that the IDs of the contacts are not equal
		assertNotEquals(contacts.contacts.get("1").getContactID(), contacts.contacts.get("2").getContactID());
		assertNotEquals(contacts.contacts.get("1").getContactID(), contacts.contacts.get("3").getContactID());
		assertNotEquals(contacts.contacts.get("2").getContactID(), contacts.contacts.get("3").getContactID());
	}
	
	// Test to make sure duplicate IDs throw errors 
	@Test 
	void testDuplicateID() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Creating ContactService class object to call upon map 
			ContactService contacts = new ContactService();
			
			// Add contacts to map 
			contacts.addContact("1", "Katie", "McNeil", "1112223344", "123 Qwerty St");
			contacts.addContact("1", "Molly", "Dog", "1112223344", "456 Abc Rd");
		});		}
	
	// Test to add and get a contact back
	@Test
	void testGetContact() {
		// Creating ContactService class object to call upon map 
		ContactService contacts = new ContactService();
		
		// Add contact to map 
		contacts.addContact("1", "Katie", "McNeil", "1112223344", "123 Qwerty St");
		
		Contact returnContact = contacts.getContact("1");
		
		// Testing to make sure contact is added and returned 
		assertEquals("1", returnContact.getContactID());
		assertEquals("Katie", returnContact.getFirstName());
		assertEquals("McNeil", returnContact.getLastName());
		assertEquals("1112223344", returnContact.getPhone());
		assertEquals("123 Qwerty St", returnContact.getAddress());
	}
	
	// Test to make sure contacts can be deleted 
	@Test
	void testDeleteContact() {
		// Creating ContactService class object to call upon map   
		ContactService contacts = new ContactService();
		
		// Add contacts to map 
		contacts.addContact("1", "Katie", "McNeil", "1112223344", "123 Qwerty St");
		contacts.addContact("2", "Molly", "Dog", "5556667788", "456 Abc Rd");
		contacts.addContact("3", "Ivan", "Cat", "9990001122", "789 Road St");
		
		// Delete contact ID 1 (this is Katie here)
		contacts.deleteContact("1");
		
		// Make sure the contacts does not contain ID # 1
		assertFalse(contacts.contacts.containsKey("1"));
	}
	
	// Test to make sure first name can be updated 
	@Test
	void testUpdateFirstName() {
		// Creating ContactService class object to call upon map
		ContactService contacts = new ContactService();
		
		// Add contact 
		contacts.addContact("1", "Katie", "McNeil", "1112223344", "123 Qwerty St");
		
		// Update contact with ID # 1 to have the first name "Molly"
		contacts.updateFirstName("1", "Molly");
		
		// Testing to make sure Molly is the first name in contact with ID #1
		assertEquals("Molly", contacts.contacts.get("1").getFirstName());
	}
	
	// Test to make sure last name can be updated 
	@Test 
	void testUpdateLastName() {
		// Creating ContactService class object to call upon map 
		ContactService contacts = new ContactService();
		
		contacts.addContact("1", "Katie", "McNeil", "1112223344", "123 Qwerty St");
		
		// Update contact with ID # 1 to have last name Badatie 
		contacts.updateLastName("1", "Badatie");
		
		// Testing to make sure Badatie is the last name in contact with ID #1
		assertEquals("Badatie", contacts.contacts.get("1").getLastName());
	}
	
	// Test to make sure phone number can be updated 
	@Test 
	void testUpdatePhone() {
		// Creating ContactService class object to call upon map 
		ContactService contacts = new ContactService();
		
		contacts.addContact("1", "Katie", "McNeil", "1112223344", "123 Qwerty St");
		
		// Update contact with ID # 1 to have different phone # 
		contacts.updatePhone("1", "2223334455");
		
		// Test to make sure phone number in ID # 1 is the new one 
		assertEquals("2223334455", contacts.contacts.get("1").getPhone());
	}
	
	// Test to make sure address can be updated 
	@Test
	void testUpdateAddress() {
		// Creating ContactService class object to call upon map
		ContactService contacts = new ContactService();
		
		contacts.addContact("1", "Katie", "McNeil", "1112223344", "123 Qwerty St");
		
		// Update contact to have new address 
		contacts.updateAddress("1", "789 Road St");
		
		// Make sure contact has the new address saved 
		assertEquals("789 Road St", contacts.contacts.get("1").getAddress());
	}
}
	
	


