import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Enter an integer:");
			String i = scanner.nextLine();
			int a = Integer.parseInt(i);
			System.out.println("The square value is " + a * a);
			System.out.println("The work has been done successfully");
		} catch (NumberFormatException e) {
			System.out
					.println("Entered input is not a valid format for an integer");
		}
	}

}
