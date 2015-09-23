public class ProductBO {
	void displayAllProductDetails(Product productList[], int count) {
		System.out.format("%-10s %-20s %-20s %-10s\n", "Id", "ProductName",
				"SupplierName", "Price");
		for (int i = 0; i < count; i++) {
			System.out
					.format("%-10d %-20s %-20s %-10d\n",
							productList[i].getId(),
							productList[i].getProductName(),
							productList[i].getSupplierName(),
							productList[i].getPrice());
		}
	}
}
