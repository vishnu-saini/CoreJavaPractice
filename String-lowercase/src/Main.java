import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the string");
		String str = scanner.nextLine();
		System.out.print("The processed string is ");
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != 'x') {
				System.out.print(str.charAt(i));
			} else {
				count++;
			}
		}
		for (int i = 0; i < count; i++) {
			System.out.print('x');
		}
	}

}
