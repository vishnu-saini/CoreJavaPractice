import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			InputStreamReader ir = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(ir);
			System.out.println("Enter the number of elements in the array");
			int size = Integer.parseInt(br.readLine());
			System.out.println("Enter the elements in the array");
			int a[] = new int[size];
			for (int i = 0; i < size; i++) {
				a[i] = Integer.parseInt(br.readLine());
			}
			System.out
					.println("Enter the index of the array element you want to access");
			int index = Integer.parseInt(br.readLine());
			System.out.println("The array element at index " + index + " = "
					+ a[index]);
			System.out.println("The array element successfully accessed");
		} catch (Exception e) {
			if (e instanceof NumberFormatException) {
				System.out.println(e.getClass().toString().substring(6));
			} else if (e instanceof ArrayIndexOutOfBoundsException) {
				System.out.println(e.getClass().toString().substring(6));
			} else if (e instanceof IOException) {
				System.out.println(e.getClass().toString().substring(6));
			}
		}
	}

}
