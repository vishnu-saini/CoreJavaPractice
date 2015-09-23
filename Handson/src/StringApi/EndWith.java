package StringApi;

import java.util.Scanner;

public class EndWith {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str,searchStr;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the string");
		str=scanner.nextLine();
		System.out.println("Enter the end string");
		searchStr=scanner.nextLine();
		boolean a = str.endsWith(searchStr);
		if(a){
			System.out.println("\""+str+"\" ends with \""+searchStr+"\"");
		}else {
			System.out.println("\""+str+"\" does not end with \""+searchStr+"\"");
		}
		
	}

}
