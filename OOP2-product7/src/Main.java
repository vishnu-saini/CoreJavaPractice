import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		String dicision;
		int priceHigh,priceLow;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Product> productList = new ArrayList<Product>();
		ProductBO productBO = new ProductBO();

		do{
		Product product = new Product();
		System.out.println("Enter the product id");
		product.setId(scanner.nextLong());
		scanner.nextLine();

		System.out.println("Enter the product name");
		product.setProductName(scanner.nextLine());

		System.out.println("Enter the supplier name");
		product.setSupplierName(scanner.nextLine());

		System.out.println("Enter the product price");
		product.setPrice(scanner.nextInt());
		scanner.nextLine();
		
		productList.add(product);
		System.out.println("Do you want to enter the details of another product? Enter yes or no (not case sensitive)");
		dicision=scanner.nextLine();
		}while(dicision.equalsIgnoreCase("yes"));
		
		System.out.println("Enter the minimum price range");
		priceLow=scanner.nextInt();
		System.out.println("Enter the maximum price range");
		priceHigh=scanner.nextInt();
		productBO.searchProductByPriceRange(productList, priceLow, priceHigh);
	}
}
