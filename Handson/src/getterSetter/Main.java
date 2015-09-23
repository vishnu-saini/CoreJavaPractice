package getterSetter;

import java.util.Scanner;

public class Main {

	public static void main(String args[]){
		
		long id;
		String productName,supplierName;
		
		Scanner scanner=new Scanner(System.in);
		Product product=new Product();
		
		System.out.println("Enter the product id");
		id=scanner.nextLong();
		System.out.println("Enter the product name");
		productName=scanner.next();
		System.out.println("Enter the supplier name");
		supplierName=scanner.next();
		
		product.setId(id);
		product.setProductName(productName);
		product.setSuppliString(supplierName);
		
		System.out.println("Product Id is "+id);
		System.out.println("Product Name is "+productName);
		System.out.println("Supplier Name is "+supplierName);

	}
}
