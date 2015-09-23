import java.util.List;

public class ProductBO {
	
	public void searchProductByPriceRange (List<Product> productList, int pl, int ph){
		boolean flag=true;
		for (Product product : productList) {
			if(product.getPrice() >= pl && product.getPrice() <= ph){
				if(flag){
					System.out.format("%-10s %-20s %-20s %-10s\n", "Id", "ProductName",
							"SupplierName", "Price");
					flag=false;
				}
				System.out.format("%-10d %-20s %-20s %-10d\n", product.getId(),product.getProductName(),product.getSupplierName(),product.getPrice());
			}
		}
		if(flag){
			System.out.println("No records found");
		}
	}
	
}
