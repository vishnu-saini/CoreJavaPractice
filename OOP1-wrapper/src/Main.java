import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter an integer");
		Integer a = scanner.nextInt();
		System.out.println("The binary equivalent of " + a + " is "
				+ Integer.toBinaryString(a));
		System.out.println("The hexadecimal equivalent of " + a + " is "
				+ Integer.toHexString(a));
		System.out.println("The octal equivalent of " + a + " is "
				+ Integer.toOctalString(a));
		System.out.println("Byte value of " + a + " is " + a.byteValue());
		System.out.println("Short value of " + a + " is " + a.shortValue());
		System.out.println("Long value of " + a + " is " + a.longValue());
		System.out.println("Float value of " + a + " is " + a.floatValue());
		System.out.println("Double value of " + a + " is " + a.doubleValue());

	}
}
