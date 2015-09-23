package stringAPI;

import java.util.Scanner;

public class Adjacent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str,strTo,strFrom;
		int length;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string");
		str = scanner.nextLine();
		length=str.length();
		for (int i = 0; i < length-1; i++) {
			if(str.charAt(i)==str.charAt(i+1)){
				str=str.replaceFirst(str.charAt(i)+""+str.charAt(i), str.charAt(i)+"*"+str.charAt(i));
				length++;
			}
		}
		System.out.println("The processed string is "+str);
	}

}
