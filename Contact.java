package contactService;

public class Contact {
	// Declaring variables for contact object 
	private String contactID;
	private String firstName;
	private String lastName;
	private String phone;
	private String address;
	
	//Creates contact object, must have field specified 
	public Contact(String contactID, String firstName, 
			String lastName, String phone, String address) { 
		// Conditionals making sure not null or exceeding character 
		// limit specified in documentation 
		if (contactID == null || contactID.length() > 10) {
			throw new IllegalArgumentException("Invalid ID");
		}
		if (firstName == null || firstName.length() > 10) {
			throw new IllegalArgumentException("Invalid first name");
		}
		if (lastName == null || lastName.length() > 10) {
			throw new IllegalArgumentException("Invalid last name");
		}
		if (phone == null || phone.length() != 10) {
			throw new IllegalArgumentException("Invalid phone number");
		}
		if (address == null || address.length() > 30) {
			throw new IllegalArgumentException("Invalid address");
		}
		// Using key word "this" to set the strings for the contact
		// For example, string in the contactID space in Contact() is set as contactID
		// Each string assigned to a variable 
		this.contactID = contactID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phone = phone;
		this.address = address;
	}
	// Creating getters 
	// When called it will return the variable 
	public String getContactID() {
		return contactID;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddress() {
		return address;
	}
	
	// Creating setters 
	public void setFirstName(String nameFirst) {
		// If the string matches the requirements 
		if(nameFirst.length() < 11 && nameFirst != null) {
			// Set is as the first name 
			this.firstName = nameFirst;
		}
	}
	public void setLastName(String nameLast) {
		// If the string matches the requirements 
		if(nameLast.length() < 11 && nameLast != null) {
			// Set it as the last name 
			this.lastName = nameLast;
		}
	}
	public void setPhone(String phoneNum) {
		// If the string matches the requirements 
		if(phoneNum.length() == 10 && phoneNum != null) {
			// Set it as the phone number 
			this.phone = phoneNum;
		}
	}
	public void setAddress(String stAddress) {
		// If the string matches the requirements 
		if(stAddress.length() < 30 && stAddress != null) {
			// Set it as the address 
			this.address = stAddress;
		}
	}
}