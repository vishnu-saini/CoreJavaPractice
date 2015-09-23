import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the number of elements in the array");
		int size = s.nextInt();
		int a[];
		a = new int[size];
		System.out.println("Enter the elements in the array");
		for (int i = 0; i < size; i++) {
			a[i] = s.nextInt();
		}
		System.out
				.println("Enter the index of the array element you want to access");
		int index = s.nextInt();
		try {

			System.out.println("The array element at index " + index + " = "
					+ a[index]);
			System.out.println("The array element successfully accessed");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e.getClass().toString().substring(6));
		}
	}
}
