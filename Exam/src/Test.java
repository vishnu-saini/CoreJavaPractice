import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		if (str.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}")) {
			sdf.setLenient(false);
			try {
				Date date = sdf.parse(str);
				System.out.println(date);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				System.out.println(false);
			}
		} else {
			System.out.println(false);
		}

	}
}
