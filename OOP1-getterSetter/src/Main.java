

import java.util.Scanner;

public class Main {

	public static void main(String args[]){
		

		Scanner scanner=new Scanner(System.in);
		Product product=new Product();
		
		System.out.println("Enter the product id");
		product.setId(scanner.nextLong());
		scanner.nextLine();
		System.out.println("Enter the product name");
		product.setProductName(scanner.next());
		System.out.println("Enter the supplier name");
		product.setSuppliString(scanner.next());

		System.out.println("Product Id is "+product.getId());
		System.out.println("Product Name is "+product.getProductName());
		System.out.println("Supplier Name is "+product.getSuppliString());

	}
}
