import java.util.Scanner;

/*
 * 1) Given a method with a date string in format dd/mm/yyyy.
 Write code to validate the given date against the given formate.
 if it is a valid date return 1 else return -1.
 Example1:
 Input= 12/06/1987
 output=1
 Example1:
 Input= 03/1/1987
 output=-1
 */
public class Problem1 {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String str;
		while (true) {
			str = scanner.nextLine();
			if (str.matches("[a-z A-Z]+")) {
				System.out.println("name sahi h");
			} else {
				System.out.println("name galat h");
			}
		}
		/*
		 * String d1; Date date = null; Scanner scanner = new
		 * Scanner(System.in); d1 = scanner.nextLine();
		 * 
		 * SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		 * 
		 * if (d1.matches("[0123456789]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}")) { try
		 * { sf.setLenient(false); date = sf.parse(d1); System.out.println(1); }
		 * catch (ParseException e) { // TODO Auto-generated catch block
		 * System.out.println(-1); } } else { System.out.println(-1); }
		 */

	}
}
