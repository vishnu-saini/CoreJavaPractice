import java.util.Iterator;
import java.util.List;

public class ProductBO {
	public void displayAllProductDetails (List<Product> productList){
		
		System.out.format("%-10s %-20s %-20s %-10s\n", "Id", "ProductName",
				"SupplierName", "Price");
		
		Iterator<Product> itr=productList.iterator();
		while (itr.hasNext()) {
			Product product = (Product) itr.next();
			System.out
			.format("%-10d %-20s %-20s %-10d\n",
					product.getId(),
					product.getProductName(),
					product.getSupplierName(),
					product.getPrice());
		}
	}
}
