import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Scanner s = new Scanner(System.in);
			System.out.println("Enter the 2 numbers");
			int a = s.nextInt();
			int b = s.nextInt();
			int q = a / b;
			System.out.println("The quotient of " + a + "/" + b + " = " + q);
		} catch (ArithmeticException e) {
			System.out.println("DivideByZeroException caught");
		} finally {
			System.out.println("Inside finally block");
		}

	}

}
