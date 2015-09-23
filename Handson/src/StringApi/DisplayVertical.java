package stringAPI;

import java.util.Scanner;

public class DisplayVertical {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		int length;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string");
		str = scanner.nextLine();
		System.out.println("The string printed vertically forwards and backwards is");
		length=str.length();
		for (int i = 0; i < length; i++) {
			System.out.println(str.charAt(i)+" "+str.charAt(length-i-1));
		}
	}

}
