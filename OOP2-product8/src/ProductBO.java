import java.util.List;

public class ProductBO {

	public void displayAllProductDetails(List<Product> productList) {
		boolean flag = true;
		for (Product product : productList) {
			if (flag) {
				System.out.format("%-10s %-20s %-20s %-10s\n", "Id",
						"ProductName", "SupplierName", "Price");
				flag = false;
			}
			System.out.format("%-10d %-20s %-20s %-10d\n", product.getId(),
					product.getProductName(), product.getSupplierName(),
					product.getPrice());
		}
		if (flag) {
			System.out.println("No records found");
		}
	}

	public void deleteProduct(List<Product> productList, String pname) {
		for (int i = 0; i < productList.size(); i++) {
			if (productList.get(i).getProductName().equals(pname)) {
				productList.remove(productList.get(i));
			}
		}
	}

}
