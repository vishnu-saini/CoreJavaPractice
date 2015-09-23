package conditionalStatement;

import java.util.Scanner;

public class Dining {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		float rail;
		String signal;
		signal=scanner.nextLine();
		rail=scanner.nextInt();
		if((signal.equals("front") && rail==1) || ((signal.equals("rear") && rail==2) )){
			System.out.println("Left Handed");
		}else if((signal.equals("front") && rail==2) || ((signal.equals("rear") && rail==1) )){
			System.out.println("Right Handed");
		}
	}
}
