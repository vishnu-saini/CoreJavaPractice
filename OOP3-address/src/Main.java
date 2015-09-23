import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		int noOfAddress;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Address> addressList = new ArrayList<Address>();
		String searchState, searchDistrict;

		System.out.println("Enter the number of addresses to be inserted");
		noOfAddress = scanner.nextInt();

		for (int i = 0; i < noOfAddress; i++) {

			Address address = new Address();
			System.out.println("Enter address " + (i + 1) + " details");
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

			addressList.add(address);

		}
		System.out.println("Enter a state name");
		searchState = scanner.nextLine();

		Address.searchDistrict(addressList, searchState);

		System.out.println("Enter a district name");
		searchDistrict = scanner.nextLine();

		Address.searchCity(addressList, searchDistrict);

	}
}
