import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int temp;
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = 0, b = 0, c = 1;
		for (int i = 1; i <= n; i++) {
			if (i <= 2) {
				System.out.print(a + " ");
			} else if (i == 3) {
				System.out.print(c+" ");
			} else if (i > 3) {
				temp = a + b + c;
				a = b;
				b = c;
				c = temp;
				System.out.print(c + " ");
			}
		}
	}
}
