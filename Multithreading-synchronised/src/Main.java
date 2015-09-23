import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Number of Counters :");
		int count = scanner.nextInt();
		scanner.nextLine();
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < count; i++) {
			System.out.println("Enter text for counter " + (i + 1) + " :");
			CountVowel cv = new CountVowel(map, scanner.nextLine());
			Thread t = new Thread(cv);
			t.start();
			try {
				t.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("Vowels count in given text are :");
		Set<Entry<Character, Integer>> entrySet = map.entrySet();
		for (Entry<Character, Integer> entry : entrySet) {
			System.out.print(entry.getKey() + ":" + entry.getValue() + " ");
		}
	}
}
