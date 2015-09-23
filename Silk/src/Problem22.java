import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem22 {

	public static void main(String[] args) {

		String s1 = "satya-narayan-bansal";

		getvalues(s1);

	}

	public static void getvalues(String s1) {
		List<String> list = new ArrayList<String>();
		String[] a = s1.split("-");
		int max = 0;
		for (int i = 0; i < a.length; i++) {
			if (a[i].length() > max) {
				max = a[i].length();
			}
		}

		for (int i = 0; i < a.length; i++) {
			if (a[i].length() == max) {
				list.add(a[i]);
			}
		}
		Collections.sort(list);
		System.out.println(list.get(0));

	}
}