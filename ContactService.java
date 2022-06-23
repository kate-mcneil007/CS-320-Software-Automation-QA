package contactService;
import java.util.HashMap;

public class ContactService {
	// Creating a hash map to hold the contacts
	public HashMap<String, Contact> contacts = new HashMap<String, Contact>();
	
	// Add contact method
	public void addContact(String contactID, String firstName, String lastName, String phone, String address) {
		// Check to see if contact ID already exists, throw exception if so  
		if (contacts.containsKey(contactID))  {
			throw new IllegalArgumentException("Invalid ID");
		// Else, try...catch any errors 
		} else {
			try {
				// Create new contact with the new contact ID, name, phone, address
				Contact contact = new Contact(contactID, firstName, 
				lastName, phone, address); 
			
				// Insert into hash map
				contacts.put(contact.getContactID(), contact);
			} 
			// Any errors are caught (invalid length, missing entry, etc)
			catch(IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Delete contact method, search map for contact ID and removes it if it is found
	public void deleteContact(String contactID) {
		if (contacts.containsKey(contactID))  {
			contacts.remove(contactID);
		}
	}
	
	// Method to get contact back from ContactService 
	public Contact getContact(String contactID) {
		if (contacts.containsKey(contactID))  {
			return contacts.get(contactID);
		}
		return null;
	}
	
	// Update first name method 
	public void updateFirstName(String contactID, String newFirstName) {
		// Search map for contact ID, if found will try 
		if (contacts.containsKey(contactID)) {
			try {
				// Set first name using new first name 
				contacts.get(contactID).setFirstName(newFirstName);
			//Will catch any errors with the name 
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Update last name method 
	public void updateLastName(String contactID, String newLastName) {
		// Searches map for contact ID, if found 
		if (contacts.containsKey(contactID)) {
			try {
				// Try to set the last name using the new last name 
				contacts.get(contactID).setLastName(newLastName);
			// Catch any errors 
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Update phone number method 
	public void updatePhone(String contactID, String newPhone) {
		// Search map for contact ID 
		if(contacts.containsKey(contactID)) {
			try {
				// Try to set phone number using the new phone number 
				contacts.get(contactID).setPhone(newPhone);	
			// Catch any errors 	
			} catch(IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}
	
	// Update address 
	public void updateAddress(String contactID, String newAddress) {
		// Search map for contact ID 
		if(contacts.containsKey(contactID)) {
			try {
				// Try to update address using new address 
				contacts.get(contactID).setAddress(newAddress);
			// Catch any errors that are found 
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			}
		}
	}
}
