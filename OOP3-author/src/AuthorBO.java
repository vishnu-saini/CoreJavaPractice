import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class AuthorBO {

	public void displayAllAuthorDetails(List<Author> authorList) {

		boolean flag = true;

		Iterator<Author> itr = authorList.iterator();
		while (itr.hasNext()) {
			
			Author author = (Author) itr.next();
			if (flag) {
				System.out.format("%-20s %-20s %-20s\n", "Name", "Email",
						"Gender");
				flag = false;
			}
			System.out.format("%-20s %-20s %-20s\n", author.getName(),
					author.getEmail(), author.getGender());
		}
		if (flag) {
			System.out.println("No records found");
		}
	}

	public void listAuthorNamesInSortedOrder(List<Author> authorList) {
		Set<String> authorNames=new TreeSet<String>();
		for(Author author:authorList){
			authorNames.add(author.getName());
		}
		Iterator<String> itr=authorNames.iterator();
		System.out.println("Alphabetically sorted author names");
		while(itr.hasNext()){
			System.out.println(itr.next());
		}
	}

	public Author findAuthorByName(List<Author> authorList, String name) {
		for(Author author:authorList){
			if(author.getName().equals(name)){
				return author;
			}
		}
		return null;
		
	}

}
