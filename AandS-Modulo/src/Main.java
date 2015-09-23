import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int a[] = new int[10];
		int b[] = new int[10];
		int count = 0, flag = 0;
		
		for (int i = 0; i < a.length; i++) {
			a[i] = sc.nextInt();
		}
		for (int i = 0; i < a.length; i++) {
			if (a[i] < 1000) {
				b[i] = a[i] % 42;
			}
		}
		for (int i = 0; i < b.length; i++) {
			flag = 0;
			for (int j = i + 1; j < b.length; j++) {
				if (b[i] == b[j]) {
					flag = 1;
					break;
				}
			}
			if (flag == 0) {
				count += 1;
			}
		}
		System.out.println(count);

	}

}
