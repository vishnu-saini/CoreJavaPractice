import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class MapTutorial {
	public static void main(String[] args) {
		// create hash map
		HashMap newmap = new HashMap();

		// populate hash map
		newmap.put(1, "tutorials");
		newmap.put(2, "point");
		newmap.put(3, "is best");

		/*******************************/
		Set<Integer> vaibhav = newmap.keySet();
		System.out.println(vaibhav);

		Iterator itr = vaibhav.iterator();
		System.out.println("Using keySet and iterator ");
		while (itr.hasNext()) {
			Integer integer = (Integer) itr.next();
			System.out.println(" key = " + integer + " :  value = "
					+ newmap.get(integer));

		}

		System.out.println("Using keySet and foreach loop ");
		for (Integer integer : vaibhav) {
			System.out.println(" key = " + integer + " :  value = "
					+ newmap.get(integer));
		}
		/**************************************/
		System.out.println("\n\n\n\n\n");
		/*****************************************/
		Set<Entry<Integer, String>> vishnu = newmap.entrySet();
		System.out.println(vishnu);

		Iterator itr2 = vishnu.iterator();
		System.out.println("Using entry set and iterator ");
		while (itr2.hasNext()) {
			Entry<Integer, String> entry = (Entry<Integer, String>) itr2.next();
			System.out.println(" key = " + entry.getKey() + " :  value = "
					+ entry.getValue());

		}

		System.out.println("using entry set and foreach");
		for (Entry<Integer, String> entry : vishnu) {
			System.out.println(" key = " + entry.getKey() + " :  value = "
					+ entry.getValue());
		}
		/****************************************/
	}
}
