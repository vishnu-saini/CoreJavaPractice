import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner sc = new Scanner(System.in);
		long a = sc.nextLong();
		long b = sc.nextLong();
		int num1 = 0, num2 = 0, num3 = 0, count = 0;
		if (a <= 99999999999l && b <= 99999999999l) {
			while (a != 0) {
				num1 = (int) (a % 10);
				num2 = (int) (b % 10);
				num3 += (int) (num1 + num2);
				if (num3 >= 10) {
					count += 1;
					num3 = 1;
				} else {
					num3 = 0;
				}
				a = a / 10;
				b = b / 10;
			}

		}
		System.out.println(count);
	}

}