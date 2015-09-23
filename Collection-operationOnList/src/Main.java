import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		List<String> list = new ArrayList<String>();
		int dicision;
		boolean flag = true;

		do {
			System.out
					.println("1. Insert\n2. Search\n3. Delete\n4. Display\n5. Exit\nEnter your choice :");
			dicision = scanner.nextInt();
			if (dicision != 5) {
				scanner.nextLine();
			}
			switch (dicision) {
			case 1:
				System.out.println("Enter the item to be inserted:");
				list.add(scanner.nextLine());
				System.out.println("Inserted successfully");
				break;
			case 2:
				System.out.println("Enter the item to search :");
				if (list.contains(scanner.nextLine())) {
					System.out.println("Item found in the list.");
				} else {
					System.out.println("Item not found in the list.");
				}
				break;
			case 3:
				System.out.println("Enter the item to delete :");
				if (list.remove(scanner.nextLine())) {
					System.out.println("Deleted successfully");
				} else {
					System.out.println("Item does not exist.");
				}
				break;
			case 4:
				System.out.println("The Items in the list are :");
				for (String string : list) {
					System.out.println(string);
				}
				break;
			case 5:
				flag = false;
				break;
			}
		} while (flag);
	}

}
