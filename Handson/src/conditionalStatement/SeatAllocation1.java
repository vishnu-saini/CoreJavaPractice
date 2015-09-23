package conditionalStatement;

import java.util.Scanner;

public class SeatAllocation1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean flag=false;
		int row,column,rollNo,i;
		Scanner scanner= new  Scanner(System.in);
		System.out.println("Enter the number of rows");
		row=scanner.nextInt();
		System.out.println("Enter the number of columns");
		column=scanner.nextInt();
		System.out.println("Enter the roll number of the student");
		rollNo=scanner.nextInt();
		if((rollNo <= column && rollNo > 0) || ((rollNo%column == 0 || rollNo%column == 1) && rollNo>0 && rollNo <= column*row)){
			System.out.println("yes");
		}else {
			System.out.println("no");
		}
	}

}
