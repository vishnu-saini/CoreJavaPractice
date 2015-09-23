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
			InputStreamReader is = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(is);
			System.out.println("Enter the number of elements in the array");
			int num = Integer.parseInt(br.readLine());
			System.out.println("Enter the elements in the array");
			int a[] = new int[num];
			for (int i = 0; i < num; i++) {
				a[i] = Integer.parseInt(br.readLine());

			}
			System.out
					.println("Enter the index of the array element you want to access");
			int index = Integer.parseInt(br.readLine());
			System.out.println("The array element at index " + index + " = "
					+ a[index]);
			System.out.println("The array element successfully accessed");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException caught");
		} catch (NumberFormatException e) {
			System.out.println("NumberFormatException caught");
		} catch (IOException e) {
			System.out.println("IOException caught");
		}
	}

}
