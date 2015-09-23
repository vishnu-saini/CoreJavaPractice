package getterSetter;

public class Product {

	private long id;
	private String ProductName;
	private String supplierName;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getProductName() {
		return ProductName;
	}
	public void setProductName(String productName) {
		ProductName = productName;
	}
	public String getSuppliString() {
		return supplierName;
	}
	public void setSuppliString(String supplierName) {
		this.supplierName = supplierName;
	}
	
	

}
