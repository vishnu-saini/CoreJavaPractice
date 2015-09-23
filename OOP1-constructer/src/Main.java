

import java.util.Scanner;

public class Main {

	public static void main(String args[]){
		
		long id;
		String productName,supplierName;
		
		Scanner scanner=new Scanner(System.in);
		
		
		System.out.println("Enter the product id");
		id=scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter the product name");
		productName=scanner.nextLine();
		System.out.println("Enter the supplier name");
		supplierName=scanner.nextLine();
		
		Product product=new Product(id,productName,supplierName);
		product.display();

	}
}
