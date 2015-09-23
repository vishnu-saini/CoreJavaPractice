package conditionalStatement;

import java.util.Scanner;

public class LabAllocation3 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c,n,count=0;
		String lab;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter x");
		a=scanner.nextInt();
		System.out.println("Enter y");
		b=scanner.nextInt();
		System.out.println("Enter z");
		c=scanner.nextInt();
		System.out.println("Enter n");
		n=scanner.nextInt();
		if(n<=a){
			count++;
		}
		if(n<=b){
			count++;
		}
		if(n<=c){
			count++;
		}
		if(count== 0){
			System.out.println("None of the labs can accommodate "+n+" students");
		}else{
			System.out.println(count+" lab(s) can accommodate "+n+" students");
		}

	}

}
