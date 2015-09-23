package StringApi;

import java.util.Scanner;

public class StartWith {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str,searchStr;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the string");
		str=scanner.nextLine();
		System.out.println("Enter the start string");
		searchStr=scanner.nextLine();
		boolean a = str.startsWith(searchStr);
		if(a){
			System.out.println("\""+str+"\" starts with \""+searchStr+"\"");
		}else {
			System.out.println("\""+str+"\" does not start with \""+searchStr+"\"");
		}
		
		
	}

}
