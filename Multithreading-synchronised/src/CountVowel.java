import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class CountVowel implements Runnable {
	TreeMap<Character, Integer> map;
	String str;
	String vowel = "AEIOUaeiou";

	public CountVowel(TreeMap<Character, Integer> map, String str) {
		// TODO Auto-generated constructor stub
		this.map = map;
		this.str = str;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

		for (int i = 0; i < str.length(); i++) {

			if (vowel.contains("" + str.charAt(i))) {
				char strch = (str.charAt(i) + "").toLowerCase().charAt(0);
				synchronized (map) {
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

	}

}
