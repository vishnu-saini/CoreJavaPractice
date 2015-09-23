import java.util.List;


public class Book {
	private String name;
	private List<Author> authorList;
	private double price;
	private int qtyInStock;
	
	public Book(){
		
	}
	public Book(String name,List<Author> authorList,double price,int qtyInStock){
		this.name = name;
		this.authorList = authorList;
		this.price = price;
		this.qtyInStock = qtyInStock;
	}
	public Book(String name,List<Author> authorList, double price){
		this.name = name;
		this.authorList = authorList;
		this.price=price;		
	}
	
	public String getName() {
		return name;
	}
	public List<Author> getAuthorList() {
		return authorList;
	}
	public double getPrice() {
		return price;
	}
	public int getQtyInStock() {
		return qtyInStock;
	}
	
	public String toString(){
		StringBuffer bookDetails=new StringBuffer();
		bookDetails.append(this.getName()).append(" authored by ");
		for (Author a : this.getAuthorList()) {
			bookDetails.append(a.getName()+" ");
		}		
		if(this.qtyInStock == 0){
			bookDetails.append("costs Rs.").append(this.price).append(" : Not Available");
		}
		else{
			bookDetails.append("costs Rs.").append(this.price).append(" : Available");
		}
		
		return bookDetails.toString();
		
	}
	
	
}
