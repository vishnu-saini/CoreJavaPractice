
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		long id;
		String productName, supplierName, decision;

		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the product id");
		id = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter the product name");
		productName = scanner.nextLine();
		System.out.println("Enter the supplier name");
		supplierName = scanner.nextLine();
		
		Product product = new Product(id, productName, supplierName);
		product.display();
		
		System.out.println("Enter the product id");
		id = scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter the product name");
		productName = scanner.nextLine();
		System.out.println("Enter the supplier name");
		supplierName = scanner.nextLine();
			
		Product product1 = new Product(id, productName, supplierName);
		product1.display();
		
		if (product.equals(product1)) {
			System.out.println("The two products are the same");
		}else {
			System.out.println("The two products are different");
		}

	}
}
