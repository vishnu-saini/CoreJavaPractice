import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

/*3) Given a method with a HasMap<Integer,String> as input.Write
 code to remove all the entries having keys multiple of 4 and
 return the size of the final hasmap.
 Example:
 Input={{2,"hi"}{8,"hello"}{12,"hellow world"}}
 output=1*/
public class Program3 {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(2, "hi");
		hm.put(8, "hello");
		hm.put(15, "yoo");
		hm.put(12, "world");
		hm.put(45, "ya");
		getvalues(hm);
	}

	public static void getvalues(HashMap<Integer, String> hm) {
		int count = 0;
		Set<Entry<Integer, String>> entrySets = hm.entrySet();
		Iterator<Entry<Integer, String>> itr = entrySets.iterator();
		while (itr.hasNext()) {
			Integer n = itr.next().getKey();
			if (n % 4 == 0) {
				itr.remove();
			}
		}

		System.out.println(hm.size());
		Set<Entry<Integer, String>> entrySets1 = hm.entrySet();
		for (Entry<Integer, String> entry : entrySets1) {
			System.out.println(" key = " + entry.getKey() + " and value = "
					+ entry.getValue());
		}
	}
}