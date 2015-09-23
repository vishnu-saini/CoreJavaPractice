import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class CountVowel extends Thread {
	TreeMap<Character, Integer> map = new TreeMap<Character, Integer>();
	String str;

	public CountVowel(String str) {
		// TODO Auto-generated constructor stub
		this.str = str;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < str.length(); i++) {

			char strch = str.charAt(i);
			boolean flag = true;
			Set<Entry<Character, Integer>> entrySet = map.entrySet();
			for (Entry<Character, Integer> entry : entrySet) {
				Character ch = entry.getKey();
				if (ch.equals(strch)) {
					flag = false;
					int in = map.get(ch);
					in++;
					map.put(ch, in);
				}
			}
			if (flag) {
				map.put(strch, 1);
			}
		}

	}

}
