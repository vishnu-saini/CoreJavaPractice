import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		String dicision;
		int i=0;
		Scanner scanner = new Scanner(System.in);
		Product[] product = new Product[50];
		ProductBO productBO = new ProductBO();

		do{
		System.out.println("Enter the product id");
		product[i]=new Product();
		product[i].setId(scanner.nextLong());
		scanner.nextLine();

		System.out.println("Enter the product name");
		product[i].setProductName(scanner.nextLine());

		System.out.println("Enter the supplier name");
		product[i].setSupplierName(scanner.nextLine());

		System.out.println("Enter the product price");
		product[i].setPrice(scanner.nextInt());
		scanner.nextLine();
		
		System.out.println("Do you want to enter the details of another product? Enter yes or no (not case sensitive)");
		dicision=scanner.nextLine();
		i++;
		}while(dicision.equalsIgnoreCase("yes"));
		
		productBO.displayAllProductDetails(product, i);
	}
}
