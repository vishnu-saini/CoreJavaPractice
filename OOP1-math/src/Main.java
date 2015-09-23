import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the first integer");
		a = scanner.nextInt();
		System.out.println("Enter the second integer");
		b = scanner.nextInt();
		System.out.println("Absolute value of " + a + " is " + Math.abs(a));
		System.out.println("Absolute value of " + b + " is " + Math.abs(b));
		if (a == b) {
			System.out.println(a + " = " + b);
		} else {
			System.out.println(a + " != " + b);
		}
	}

}
