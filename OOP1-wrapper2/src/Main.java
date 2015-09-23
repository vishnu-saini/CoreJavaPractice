import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the binary number");
		String binary = scanner.nextLine();
		System.out.println("Enter the octal number");
		String octal = scanner.nextLine();
		System.out.println("Enter the hexadecimal number");
		String hex = scanner.nextLine();

		System.out.println("The integer value of the binary number " + binary
				+ " is " + Integer.parseInt(binary, 2));
		System.out.println("The integer value of the octal number " + octal
				+ " is " + Integer.parseInt(octal, 8));
		System.out.println("The integer value of the hexadecimal number " + hex
				+ " is " + Integer.parseInt(hex, 16));

	}
}
