package conditionalStatement;

import java.util.Scanner;

public class LabAllocation2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		String lab;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter x");
		a=scanner.nextInt();
		System.out.println("Enter y");
		b=scanner.nextInt();
		System.out.println("Enter z");
		c=scanner.nextInt();
		System.out.println("Enter the lab allocated for ACE training");
		lab=scanner.nextLine();
		if(lab.equals("L1")){
			if(b<c) 
				System.out.println("L2 has the minimal seating capacity");
			else
				System.out.println("L3 has the minimal seating capacity");
		}else if(lab.equals("L2")){
			if(a<c)
				System.out.println("L1 has the minimal seating capacity");
			else
				System.out.println("L3 has the minimal seating capacity");
			
		}else if(lab.equals("L3")){
			if(a<b)
				System.out.println("L1 has the minimal seating capacity");
			else
				System.out.println("L2 has the minimal seating capacity");
		}

	}

}
