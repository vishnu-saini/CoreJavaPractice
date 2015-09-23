package Collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ListExample {
	public static void main(String[] args) {

		List<Integer> list = new ArrayList<Integer>();
		Scanner scanner = new Scanner(System.in);

		for (int i = 0; i < 10; i++) {
			list.add(scanner.nextInt());
		}

		for (Integer integer : list) {
			System.out.println("value is = " + integer);
		}

		Iterator<Integer> it = list.iterator();
		while (it.hasNext()) {
			System.out.println("value is = " + it.next());

		}
	}
}
