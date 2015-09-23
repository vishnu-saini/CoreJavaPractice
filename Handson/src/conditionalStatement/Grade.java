package conditionalStatement;

import java.util.Scanner;

public class Grade {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a;
		char grade;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the marks");
		a=scanner.nextInt();
		if( a==100){
			grade='S';
		}else if(a>=90 && a<100){
			grade='A';
		}else if(a>=80 && a<90){
			grade='B';
		}else if(a>=70 && a<80){
			grade='C';
		}else if(a>=60 && a<70){
			grade='D';
		}else if(a>=50 && a<60){
			grade='E';
		}else if(a<50  && a>=0){
			grade='F';
		}else{
			grade='g';
		}
		if(grade == 'g')
			System.out.println("Invalid Input");
		else
		System.out.println("The student obtained a "+grade+" grade");
	}
}
