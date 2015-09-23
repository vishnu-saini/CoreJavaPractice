import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		long id;
		String productName, supplierName;
		Scanner scanner = new Scanner(System.in);
		Product product = new Product();

		System.out.println("Enter the product id");
		id = scanner.nextLong();
		product.setId(id);
		scanner.nextLine();

		System.out.println("Enter the product name");
		productName = scanner.nextLine();
		product.setProductName(productName);

		System.out.println("Enter the supplier name");
		supplierName = scanner.nextLine();
		product.setSupplierName(supplierName);

		System.out.println("Product Id is " + product.getId());
		System.out.println("Product Name is " + product.getProductName());
		System.out.println("Supplier Name is " + product.getSupplierName());

	}
}
