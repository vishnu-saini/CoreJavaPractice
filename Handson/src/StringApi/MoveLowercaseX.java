package stringAPI;

import java.util.Scanner;

public class MoveLowercaseX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str,strTo,strFrom;
		int length,count=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string");
		str = scanner.nextLine();
		length=str.length();
		for (int i = 0; i < length-1; i++) {
			if(str.charAt(i)=='x'){
				count++;
			}
		}
		str=str.replace("x", "");
		for (int i = 0; i < count; i++) {
			str=str+"x";
		}
		System.out.println("The processed string is "+str);
	}

}
