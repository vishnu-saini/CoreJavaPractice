import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int m, k, count = 0, result, a;
		long num, tempNum;

		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		num = m * m;
		tempNum = num;
		k = m;
		result = k;
		while (tempNum != 0) {
			count += 1;
			tempNum = tempNum / 10;
		}
		if (count != 1) {
			if (count % 2 == 0) {

				a = (int) Math.pow(10, count / 2);
				result = (int) ((num % a) + (num / a));
			} else {

				a = (int) (Math.pow(10, (count / 2) + 1));
				result = (int) ((num % a) + (num / a));
			}
		}
		if (result == k)
			System.out.println("Kaprekar Number");
		else
			System.out.println("Not A Kaprekar Number");

	}
}
