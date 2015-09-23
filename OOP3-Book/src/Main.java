import java.util.*;


public class Main {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		List<Author> authorList = new ArrayList<Author>(); 
		Author a = new Author();
		Book b = new Book();
		int count = 0;		
		
		System.out.println("Enter the book name");
		String bname = s.nextLine();
		
		System.out.println("Enter the number of authors");		
		count =s.nextInt();
		s.nextLine();
		
		for(int i=1;i<=count;i++){
			System.out.println("Enter the author name");
			a.setName(s.nextLine());
			System.out.println("Enter the author email id");
			a.setEmail(s.nextLine());
			System.out.println("Enter the author's gender");
			a.setGender(s.nextLine());
			authorList.add(new Author(a.getName(),a.getEmail(),a.getGender()));
		}
		
		System.out.println("Enter the book price");
		double price = s.nextDouble();
		s.nextLine();
		
		System.out.println("Is the book currently available? Type Yes/No (Not case sensitive)");
		String available = s.next();
		
		if(available.equalsIgnoreCase("yes")){			
			System.out.println("Enter the number of books available");
			int nob = s.nextInt();
			b = new Book(bname,authorList,price,nob);
			System.out.println(b.toString());
		}
		else{			
			b = new Book(bname,authorList,price);
			System.out.println(b.toString());
		}
		
	}

}
