public class Product {

	private long id;
	private String productName;
	private String supplierName;
	private int price;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(long id, String productName, String supplierName, int price) {
		this.id = id;
		this.productName = productName;
		this.supplierName = supplierName;
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}

}
