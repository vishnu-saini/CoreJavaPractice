

import java.util.Scanner;

public class Main {

	public static void main(String args[]){
		
		long id;
		String productName,supplierName,decision;
		
		Scanner scanner=new Scanner(System.in);
		
		
		System.out.println("Enter the product id");
		id=scanner.nextLong();
		scanner.nextLine();
		System.out.println("Enter the product name");
		productName=scanner.nextLine();
		System.out.println("Is the product supplied by Nivas Suppliers? Type yes or no (not case sensitive)");
		decision=scanner.nextLine();
		if(decision.equalsIgnoreCase("yes")){
			Product product=new Product(id,productName);
			product.display();
		}else if(decision.equalsIgnoreCase("no")){
			System.out.println("Enter the supplier name");
			supplierName=scanner.nextLine();
			Product product=new Product(id,productName,supplierName);
			product.display();
		}
		

	}
}
