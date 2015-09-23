import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int a[], b[], count = 0;
		boolean flag;
		a = new int[10];
		b = new int[10];

		Scanner scanner = new Scanner(System.in);
		for (int i = 0; i < 10; i++) {
			flag = true;
			a[i] = scanner.nextInt();
			for (int k = 0; k < count; k++) {
				if (b[k] == a[i] % 42) {
					flag = false;
					break;
				}
			}
			if (flag) {
				b[count] = a[i] % 42;
				count++;
			}
		}
		System.out.println(count);
	}
}
