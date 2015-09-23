package conditionalStatement;

import java.util.Scanner;

public class MovieTicket {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int age;
		String showTime;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter your age");
		age = scanner.nextInt();
		System.out.println("Enter show timing");
		showTime = scanner.next();

		if (showTime.equals("13.30")) {
			if (age <= 13) {
				System.out.println("The ticket price is $2.00");
			} else {
				System.out.println("The ticket price is $5.00");
			}
		} else {
			if (age <= 13) {
				System.out.println("The ticket price is $4.00");
			} else {
				System.out.println("The ticket price is $8.00");
			}

		}
	}

}
