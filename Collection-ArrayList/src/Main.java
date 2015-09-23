import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int noOfEmployee;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Number of Employees");
		noOfEmployee = scanner.nextInt();
		scanner.nextLine();
		List<Employee> register = new ArrayList<Employee>();
		for (int i = 0; i < noOfEmployee; i++) {
			Employee employee = new Employee();
			System.out.println("Enter Employee " + (i + 1) + " Details:");
			System.out.println("Enter the Firstname");
			employee.setFirstName(scanner.nextLine());
			System.out.println("Enter the Lastname");
			employee.setLastName(scanner.nextLine());
			System.out.println("Enter the Mobile");
			employee.setMobileNumber(scanner.nextLine());
			System.out.println("Enter the Email");
			employee.setEmailAddress(scanner.nextLine());
			System.out.println("Enter the Address");
			employee.setAddress(scanner.nextLine());

			register.add(employee);
		}
		for (int i = 0; i < noOfEmployee; i++) {
			for (int j = i + 1; j < noOfEmployee; j++) {
				if (register.get(i).getFirstName()
						.compareTo(register.get(j).getFirstName()) > 0) {
					Collections.swap(register, i, j);
				}
			}
		}
		System.out.println("Employee List:");
		System.out.format("%-15s %-15s %-15s %-30s %-15s\n", "Firstname",
				"Lastname", "Mobile", "Email", "Address");
		for (Employee employee : register) {
			System.out.format("%-15s %-15s %-15s %-30s %-15s\n",
					employee.getFirstName(), employee.getLastName(),
					employee.getMobileNumber(), employee.getEmailAddress(),
					employee.getAddress());
		}

	}

}
