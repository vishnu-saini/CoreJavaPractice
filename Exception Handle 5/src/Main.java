import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter your age");
			int age = s.nextInt();
			if (age < 19) {
				throw new Exception();
			} else {
				System.out.println("welcome to vote");
			}
		} catch (Exception e) {
			System.out
					.println("Exception occured: InvalidAgeException: not valid");
		}
	}

}
