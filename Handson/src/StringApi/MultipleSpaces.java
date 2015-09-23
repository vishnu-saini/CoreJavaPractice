package stringAPI;

import java.util.Scanner;

public class MultipleSpaces {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string");
		str = scanner.nextLine();
		str = str.replaceAll("\\s+", " ");
		System.out.println("The processed string is "+str);
	}

}
