public class ProductBO {
	void displayProductDetails(Product product) {
		System.out.println("Product Id is " + product.getId());
		System.out.println("Product Name is " + product.getProductName());
		System.out.println("Supplier Name is " + product.getSupplierName());
		System.out.println("Product price is " + product.getPrice());
	}

	public void updateProductName(Product product, String pname) {
		product.setProductName(pname);
	}

	public void updateSupplierName(Product product, String sname) {
		product.setSupplierName(sname);
	}

	public void updateProductPrice(Product product, int p) {
		product.setPrice(p);
	}
}
