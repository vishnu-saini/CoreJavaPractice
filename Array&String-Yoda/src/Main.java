import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		Scanner scanner = new Scanner(System.in);
		str = scanner.nextLine();

		String[] words = str.split("\\s+");
		if (words.length > 2) {

			int index = str.indexOf(" ");
			String first = str.substring(0, index);
			str = str.substring(index + 1);
			index = str.indexOf(" ");
			String second = str.substring(0, index);
			str = str.substring(index + 1);
			System.out.println(str + " " + first + " " + second);
		} else {
			System.out.println(str);
		}
	}

}
