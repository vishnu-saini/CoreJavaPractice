import java.util.Scanner;

public class Programe7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str;
		int a, sum;
		do {
			sum = 0;
			System.out.println("Enter String : ");
			str = scanner.nextLine();
			for (int i = 0; i < str.length(); i++) {
				char ch = str.charAt(i);
				if (Character.isDigit(ch)) {
					a = Integer.parseInt(Character.toString(ch));
					sum=sum+a;
				}
			}
			System.out.println("Output : "+sum);
			System.out.println("Enter yes if you want to check once again");
		} while (scanner.nextLine().toLowerCase().equals("yes"));
	}

}
