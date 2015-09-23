package inputAndOutputStatement;

import java.util.Scanner;

public class Ttt5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String a,b,c;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Word in the Trophy :");
		a=scanner.nextLine();
		System.out.println("Malfoy picks the character :");
		b=scanner.nextLine();
		System.out.println("Malfoy replaces the character with :");
		c=scanner.nextLine();
		System.out.println("Hedwig must replace "+c+" with "+b+" in the word "+a+".");
	}

}
