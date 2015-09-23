import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		int dicision;
		Scanner scanner = new Scanner(System.in);
		ArrayList<User> userList = new ArrayList<User>();
		System.out.println("Enter the number of user details to be inserted");
		int number = scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < number; i++) {

			User user = new User();
			System.out.println("Enter details of user " + (i + 1));
			System.out.println("Enter name");
			user.setName(scanner.nextLine());
			System.out.println("Enter mobile number");
			user.setMobileNumber(scanner.nextLine());
			System.out.println("Enter email address");
			user.setEmail(scanner.nextLine());

			Address address = new Address();
			System.out.println("Enter address details");
			System.out.println("Enter door number");
			address.setDoorNumber(scanner.nextInt());
			scanner.nextLine();
			System.out.println("Enter street name");
			address.setStreet(scanner.nextLine());
			System.out.println("Enter city name");
			address.setCity(scanner.nextLine());
			System.out.println("Enter district name");
			address.setDistrict(scanner.nextLine());
			System.out.println("Enter state name");
			address.setState(scanner.nextLine());
			System.out.println("Enter pin code");
			address.setPinCode(scanner.nextInt());
			scanner.nextLine();
			System.out.println("Enter credit card number");
			user.setCreditCardNumber(scanner.nextLine());
			user.setAddress(address);
			userList.add(user);
		}
		System.out
				.println("Menu\n1) Search for user details using mobile number.\n2) Search for user details using mobile number and then change the email id of the above user to new id provided.");
		System.out
				.println("3) List the names of users in which the given string is a substring.\n4) List the names of users from a particular district.\nAny other choice : Exit");
		String mobileNo, newEmail, subName, district;
		boolean flag = true;
		do {
			System.out.println("Enter your choice");
			dicision = scanner.nextInt();
			scanner.nextLine();
			switch (dicision) {
			case 1:
				System.out.println("Enter the mobile number");
				mobileNo = scanner.nextLine();
				User.findUserByMobileNo(userList, mobileNo);
				break;
			case 2:
				System.out.println("Enter the mobile number");
				mobileNo = scanner.nextLine();
				System.out.println("Enter the new email id");
				newEmail = scanner.nextLine();
				User.changeEmailIdOfUser(userList, mobileNo, newEmail);
				break;
			case 3:
				System.out.println("Enter the substring");
				subName = scanner.nextLine();
				User.findUserBySubName(userList, subName);
				break;
			case 4:
				System.out.println("Enter the district name");
				district = scanner.nextLine();
				User.findUserFromDistrict(userList, district);
				break;
			default:
				flag = false;
				break;
			}
		} while (flag);
		System.out.println("Application Terminated");

	}
}
