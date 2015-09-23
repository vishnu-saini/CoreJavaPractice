import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		long id;
		String productName, supplierName;
		int price;
		Scanner scanner = new Scanner(System.in);

		ProductBO productBO = new ProductBO();

		System.out.println("Enter the product id");
		id = scanner.nextLong();

		System.out.println("Enter the product name");
		productName = scanner.nextLine();

		System.out.println("Enter the supplier name");
		supplierName = scanner.nextLine();

		System.out.println("Enter the product price");
		price = scanner.nextInt();

		Product product = new Product(id, productName, supplierName, price);

		productBO.displayProductDetails(product);

	}
}
