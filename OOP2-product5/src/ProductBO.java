import java.util.Iterator;
import java.util.List;

public class ProductBO {
	public void displayAllProductDetails (List<Product> productList, String pname){
		
		boolean flag=true;

		Iterator<Product> itr=productList.iterator();
		while (itr.hasNext()) {
			
			Product product = (Product) itr.next();
			if(product.getProductName().equals(pname)){
				if(flag){
					System.out.format("%-10s %-20s %-20s %-10s\n", "Id", "ProductName",
							"SupplierName", "Price");
					flag=false;
				}
			
			System.out
			.format("%-10d %-20s %-20s %-10d\n",
					product.getId(),
					product.getProductName(),
					product.getSupplierName(),
					product.getPrice());
			}
		}
		if(flag){
			System.out.println("No records found");
		}
	}
}

