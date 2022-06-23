package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import contactService.Contact;

// Test class 
class ContactTest {
	// Creating a test contact object, make sure get info set 
	@Test
	void testContact() {
		Contact contact = new Contact("12345", "Katie", "McNeil", 
				"1234567890", "123 Qwerty St");
		
		assertTrue(contact.getContactID().equals("12345"));
		assertTrue(contact.getFirstName().equals("Katie"));
		assertTrue(contact.getLastName().equals("McNeil"));
		assertTrue(contact.getPhone().equals("1234567890"));
		assertTrue(contact.getAddress().equals("123 Qwerty St"));
	}
	
	// Tests making sure length does not exceed the limit
	@Test 
	void testIDLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("12345678901", "Katie", "McNeil", "1234567890", "123 Qwerty St");
		});		}
	
	@Test
	void testFirstNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "KathrynGraceMcNeil", "McNeil", "1234567890", "123 Qwerty St");
			
		}); 	}
	
	@Test
	void testLastNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Katie", "KathrynGraceMcNeil", "1234567890", "123 Qwerty St");
			
		}); 	}
	
	// Tests making sure phone is no more or less than 10 digits 
	@Test
	void testPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Katie", "McNeil", "12345678902", "123 Qwerty St");
			
		}); 	}
	
	@Test
	void testPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Katie", "McNeil", "123456789", "123 Qwerty St");
			
		}); 	}
	
	@Test
	void testAddressLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Katie", "McNeil", "1234567890", "123 Qwerty St, Abcde Massachusetts, 12345");
			
		}); 	}
	
	// Tests making sure not null
	@Test 
	void testIDNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact(null, "Katie", "McNeil", "1234567890", "123 Qwerty St");
		});		}
	
	@Test
	void testFirstNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", null, "McNeil", "1234567890", "123 Qwerty St");
			
		}); 	}
	
	@Test
	void testLastNamenull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Katie", null, "1234567890", "123 Qwerty St");
			
		}); 	}
	
	@Test
	void testPhoneNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Katie", "McNeil", null, "123 Qwerty St");
			
		}); 	}
	
	@Test
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact("1234567890", "Katie", "McNeil", "1234567890", null);
			
		}); 	}
}
