import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class Program6 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int key, marks;
		for (int i = 0; i < 2; i++) {
			System.out.println("Enter Key : ");
			key = scanner.nextInt();
			System.out.println("Enter Marks : ");
			marks = scanner.nextInt();
			map.put(key, marks);
		}
		Map<Integer, String> resultMap = findMedal(map);

		Set<Entry<Integer, String>> entrySets = resultMap.entrySet();

		for (Entry<Integer, String> entry : entrySets) {
			System.out.println(entry.getValue() + ":" + entry.getValue() + " ");
		}
	}

	public static HashMap findMedal(HashMap map) {
		HashMap<Integer, String> resultMap = new HashMap<Integer, String>();
		Set<Integer> keys = map.keySet();
		for (Integer key : keys) {
			int mark = (Integer) map.get(key);
			if (mark >= 90 && mark <= 100) {
				resultMap.put(key, "Gold");
			} else if (mark >= 80) {
				resultMap.put(key, "Silver");
			} else if (mark >= 70) {
				resultMap.put(key, "Bronze");
			}
		}
		return resultMap;
	}
}
