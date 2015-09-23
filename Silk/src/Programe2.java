/*2) Given a methodtaking a person name in the formate-"FirstName
lastName".write code to return the person name in the following
formate-"LastName","InitialOfName".
Example:
Input:Jessica Miller
output:Miller,J*/


import java.util.Scanner;

public class Programe2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String name=scanner.nextLine();
		String []nameStrings=name.split("\\s+");
		StringBuffer sb=new StringBuffer();
		sb.append(nameStrings[1]).append(",").append(name.charAt(0));
		System.out.println(sb.toString());
	}

}
