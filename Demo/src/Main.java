public class Main {
	public static void main(String[] args) {

		/* split */
		String a = "kanisk mohan madhuni is a bad boy";
		String b[] = a.split(" ");
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}

		/*
		 * regex
		 * 
		 * String a = "My name  	saini		  is My vishnu saini";
		 * System.out.println(a.replaceAll("\\s+", "+"));
		 * System.out.println(a.replaceAll("^My", "+"));
		 * System.out.println(a.replaceAll("saini$", "+"));
		 * System.out.println(a.replaceAll("[iu]", "+"));
		 * System.out.println(a.replaceAll("[in][su]", "+"));
		 * System.out.println(a.replaceAll("[^in]", "+"));
		 */
		/*
		 * String a, b, c; Scanner scanner = new Scanner(System.in); a = new
		 * String("vishnus"); b = new String("  vishnu "); c = new
		 * String("I love my india"); char arr2[] = new char[10]; String arr[] =
		 * new String[5]; System.out.println(a.charAt(0));
		 * System.out.println(a.indexOf('s'));
		 * System.out.println(a.substring(3)); System.out.println(a.substring(3,
		 * 5)); System.out.println(a.equals("vishnus"));
		 * System.out.println(a.equals("ksjdkofjio"));
		 * System.out.println(a.endsWith("us"));
		 * System.out.println(a.endsWith("US"));
		 * System.out.println(a.equalsIgnoreCase("VISHNUS"));
		 * System.out.println(a.equals("VISHNUS"));
		 * System.out.println(a.indexOf("shn")); System.out.print(a.substring(0,
		 * 2)); System.out.print(a.substring(2, 4));
		 * System.out.println(a.substring(4)); System.out.println(b.isEmpty());
		 * System.out.println(a.isEmpty()); System.out.println(b);
		 * System.out.println(b.trim()); System.out.println(c); arr =
		 * c.split(" "); System.out.println(arr[0]); System.out.println(arr[1]);
		 * System.out.println(arr[2]); System.out.println(arr[3]);
		 * System.out.println(a.lastIndexOf('s'));
		 * System.out.println(a.length());
		 * System.out.println(a.lastIndexOf("us"));
		 * 
		 * StringBuffer str=new StringBuffer(); str.append(a)
		 */

	}
}