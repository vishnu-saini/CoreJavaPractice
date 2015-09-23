package conditionalStatement;

import java.util.Scanner;

public class LabAllocation1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter x");
		a=scanner.nextInt();
		System.out.println("Enter y");
		b=scanner.nextInt();
		System.out.println("Enter z");
		c=scanner.nextInt();
		if(a<b && a<c){
			System.out.println("L1 has the minimal seating capacity");
		}else if (b<c) {
			System.out.println("L2 has the minimal seating capacity");
		}else {
			System.out.println("L3 has the minimal seating capacity");
		}
	}

}
