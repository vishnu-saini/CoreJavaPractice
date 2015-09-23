import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class User {

	private String name;
	private String mobileNumber;
	private String email;
	private Address address;
	private String creditCardNumber;

	public User() {

	}

	public User(String name, String mobileNumber, String email,
			Address address, String creditCardNumber) {
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.email = email;
		this.address = address;
		this.creditCardNumber = creditCardNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public static void findUserByMobileNo(ArrayList<User> userList,
			String mobileNo) {
		boolean mofalg = true;
		for (User user : userList) {
			if (user.getMobileNumber().equals(mobileNo)) {
				mofalg = false;
				System.out.println("User Details:");
				System.out.println("Name : " + user.getName());
				System.out.println("Email : " + user.getEmail());
				System.out.println("Credit Card Number : "
						+ user.getCreditCardNumber());

			}
		}
		if (mofalg) {
			System.out.println("No records found");
		}
	}

	public static void changeEmailIdOfUser(ArrayList<User> userList,
			String mobileNo, String newEmail) {

		Iterator<User> it = userList.iterator();
		while (it.hasNext()) {
			User user = it.next();
			if (user.getMobileNumber().equals(mobileNo)) {
				user.setEmail(newEmail);

			}

		}
	}

	public static void findUserBySubName(ArrayList<User> userList,
			String subName) {
		boolean mofalg1 = true;
		List<String> foundUsers = new ArrayList<String>();
		for (User user : userList) {
			if (user.getName().contains(subName)) {

				foundUsers.add(user.getName());

			}
		}
		Collections.sort(foundUsers);
		for (String string : foundUsers) {
			if (mofalg1) {
				System.out
						.println("List of user names that contain the substring "
								+ subName);
				mofalg1 = false;
			}
			System.out.println(string);
		}

		if (mofalg1) {
			System.out.println("No records found");
		}
	}

	public static void findUserFromDistrict(ArrayList<User> userList,
			String district) {
		boolean mofalg2 = true;
		List<String> foundUsers = new ArrayList<String>();
		for (User user : userList) {
			if (user.getAddress().getDistrict().equals(district)) {

				foundUsers.add(user.getName());

			}
		}
		Collections.sort(foundUsers);
		for (String string : foundUsers) {
			if (mofalg2) {
				System.out.println("List of users from " + district);
				mofalg2 = false;
			}
			System.out.println(string);
		}
		if (mofalg2) {
			System.out.println("No records found");
		}
	}
}
