import java.util.ArrayList;
import java.util.List;
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
		List<CountVowel> countVowels=new ArrayList<CountVowel>();  
		TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
		for (int i = 0; i < count; i++) {
			System.out.println("Enter text for counter " + (i + 1) + " :");
			CountVowel cv = new CountVowel(scanner.nextLine());
			cv.start();
			try {
				cv.join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			countVowels.add(cv);
		}
		int i=0;
		for (CountVowel countVowel : countVowels) {
			i++;
			System.out.println("Counter "+i+" Result :");
			Set<Entry<Character, Integer>> entrySet=countVowel.map.entrySet();
			for (Entry<Character, Integer> entry : entrySet) {
				System.out.print(entry.getKey()+":"+entry.getValue()+" ");
			}
			System.out.println();
		}

	}
}
