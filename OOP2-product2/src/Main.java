import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		long id;
		String productName, supplierName;
		int price, dicision;
		Scanner scanner = new Scanner(System.in);
		Product product = new Product();
		ProductBO productBO = new ProductBO();

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

		System.out.println("Enter the product price");
		price = scanner.nextInt();
		scanner.nextLine();
		product.setPrice(price);

		productBO.displayProductDetails(product);
		System.out.println("Update Menu :");
		System.out.println("1) Update product name");
		System.out.println("2) Update supplier name");
		System.out.println("3) Update product price");
		System.out.println("Enter Choice");
		dicision = scanner.nextInt();
		scanner.nextLine();
		switch (dicision) {
		case 1:
			System.out.println("Enter new product name");
			productBO.updateProductName(product, scanner.nextLine());
			break;
		case 2:
			System.out.println("Enter new supplier name");
			productBO.updateSupplierName(product, scanner.nextLine());
			break;
		case 3:
			System.out.println("Enter new product price");
			productBO.updateProductPrice(product, scanner.nextInt());
			break;
		}
		productBO.displayProductDetails(product);
	}
}
