package StringApi;

import java.util.Scanner;

public class LastIndexOf {

	public static void main(String args[]){
		String str,searchStr;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the string");
		str=scanner.nextLine();
		System.out.println("Enter the string to be searched");
		searchStr=scanner.nextLine();
		int index=str.lastIndexOf(searchStr);
		System.out.println("The index of last occurence of \""+searchStr+"\" is "+index);
		System.out.println("Enter the index limit");
		int fromIndex=scanner.nextInt();
		index=str.lastIndexOf(searchStr,fromIndex);
		System.out.println("First occurence of \""+searchStr+"\" from "+fromIndex+"th index backwards is "+index);
	}
}
