package stringAPI;

import java.util.Scanner;

public class Uppercase {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str,strTo,strFrom;
		int length,count=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string");
		str = scanner.nextLine();
		length=str.length();
		for (int i = 0; i < length-1; i++) {
			System.out.println(str.charAt(i));
			if(str.charAt(i)== ' ' ){
				System.out.println((new String(str.charAt(i+1))).toUpperCase() );
			}
		}
	}

}
