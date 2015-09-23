import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String args[]) {

		String dicision;
		Scanner scanner = new Scanner(System.in);
		ArrayList<Author> myList = new ArrayList<Author>();
		AuthorBO authorBO = new AuthorBO();

		do{
		Author product = new Author();
		System.out.println("Enter the author name");
		product.setName(scanner.nextLine());

		System.out.println("Enter the author email id");
		product.setEmail(scanner.nextLine());

		System.out.println("Enter the author's gender");
		product.setGender(scanner.nextLine());

		myList.add(product);
		
		System.out.println("Do you want to add the details of another author? Type Yes/No (Not case sensitive)");
		dicision=scanner.nextLine();
		}while(dicision.equalsIgnoreCase("yes"));
		
		authorBO.displayAllAuthorDetails(myList);
		
		System.out.println("Enter the name of the author to be searched");
		Author authorFound=authorBO.findAuthorByName(myList, scanner.nextLine());
		if(authorFound ==  null){
			System.out.println("Author not found");
		}else {
			System.out.format("%s (%s) contact at %s\n", authorFound.getName()
					, authorFound.getGender(),authorFound.getEmail());
		}
		authorBO.listAuthorNamesInSortedOrder(myList);
	}
}
