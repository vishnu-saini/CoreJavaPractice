import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Set1Program29 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter size");
		int size = scanner.nextInt();
		System.out.println("Enter element");
		int arr[] = new int[size];

		for (int i = 0; i < size; i++) {
			arr[i] = scanner.nextInt();
		}

		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < size; i++) {
			list.add(arr[i]);
		}
		System.out.println(list);
		System.out.println("Enter element to delete");
		int element = scanner.nextInt();
		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			if (itr.next().equals(element)) {
				itr.remove();
			}

		}
		System.out.println(list);
		int b[] = new int[list.size()];

		for (int i = 0; i < list.size(); i++) {
			b[i] = list.get(i);
			System.out.println(b[i]);
		}

	}
}
