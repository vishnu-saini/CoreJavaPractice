import java.util.List;
import java.util.Scanner;

//STEP 1. Import required packages

public class Main {

	public static void main(String[] args) {

		System.out.println("Before the insert");

		System.out.format("%-15s %-15s %-30s %-15s\n", "FirstName", "LastName",
				"Email", "PhoneNumber");

		ContactBO bo = new ContactBO();
		List<Contact> contactList = bo.getAllContacts();

		for (Contact contact : contactList) {

			System.out.format("%-15s %-15s %-30s %-15s\n",
					contact.getFirstName(), contact.getLastName(),
					contact.getEmail(), contact.getPhoneNo());
		}
		Scanner inp = new Scanner(System.in);
		System.out.println("Enter Contact Table Inputs");
		System.out.println("Enter The FirstName :");
		String firstName = inp.nextLine();
		System.out.println("Enter The LastName :");
		String lastName = inp.nextLine();
		System.out.println("Enter The Email :");
		String email = inp.nextLine();
		System.out.println("Enter The PhoneNumber :");
		String phone = inp.nextLine();
		Contact contact1 = new Contact(firstName, lastName, email, phone);
		bo.insertContact(contact1);
		System.out.println("After the insert");
		contactList = bo.getAllContacts();
		for (Contact contact : contactList) {

			System.out.format("%-15s %-15s %-30s %-15s\n",
					contact.getFirstName(), contact.getLastName(),
					contact.getEmail(), contact.getPhoneNo());
		}

	}
}
