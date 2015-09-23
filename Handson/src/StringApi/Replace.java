package stringAPI;

import java.util.Scanner;

public class Replace {
	public static void main(String[] args) {
		String str, oldName, newName;
		Scanner scanner = new Scanner(System.in);

		System.out.println("Enter the content of the document");
		str = scanner.nextLine();
		System.out.println("Enter the old name of the company");
		oldName = scanner.next();
		System.out.println("Enter the new name of the company");
		newName = scanner.next();

		str = str.replace(oldName, newName);
		System.out.println("The content of the modified document is");
		System.out.println(str);
		
	}
}
