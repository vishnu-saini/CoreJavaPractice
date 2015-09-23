package conditionalStatement;

import java.util.Scanner;

public class CompareInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b;
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter the first number");
		a=scanner.nextInt();
		System.out.println("Enter the second number");
		b=scanner.nextInt();
		if(a<b)
			System.out.println(a+" is less than "+b);
		else if (a == b) 
			System.out.println(a+" is equal to "+b);
		else
			System.out.println(a+" is greater than "+b);
	}

}
