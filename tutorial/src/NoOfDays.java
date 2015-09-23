import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class NoOfDays {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date date = null;
		Date date2 = new Date();
		System.out.println(date2);
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		String str2 = scanner.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			date = sdf.parse(str);
			date2 = sdf.parse(str2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		long diff = date2.getTime() - date.getTime();
		System.out.println(diff / (1000 * 60 * 60 * 24));
	}
}
