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
		char chrStr[] = str.toCharArray();
		System.out.println("Capitalized version:");
		for (int i = 0; i < chrStr.length; i++) {
			if (chrStr[i] == ' ' && i < chrStr.length - 2) {
				if (chrStr[i + 1] >= 97 && chrStr[i + 1] <= 123) {
					chrStr[i + 1] = (char) (chrStr[i + 1] - 32);
				}
			} else if (i == 0 && chrStr[i] >= 97 && chrStr[i] <= 123) {
				chrStr[i] = (char) (chrStr[i] - 32);
			}
			System.out.print(chrStr[i]);
		}
	}

}
