import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class date {

	/**
	 * @param args
	 * @throws ParseException
	 */
	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String d1 = scanner.nextLine();
		String d2 = scanner.nextLine();
		SimpleDateFormat format = new SimpleDateFormat("DD/MM/yyyy");
		Date dd1 = format.parse(d1);
		Date dd2 = format.parse(d2);
		System.out.println(dd1);
		System.out.println(dd2);

		Calendar startCalendar = new GregorianCalendar();
		startCalendar.setTime(dd1);

		System.out.println(startCalendar.get(Calendar.YEAR));
		System.out.println(startCalendar.get(Calendar.DAY_OF_MONTH));
		System.out.println(startCalendar.get(Calendar.MONTH));

		Calendar sDate = Calendar.getInstance();
		Calendar eDate = Calendar.getInstance();
		sDate.setTime(dd1);
		eDate.setTime(dd2);

		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
		System.out.println(sdf.format(sDate.getTime()));

		int difInMonths = sDate.get(Calendar.MONTH) - eDate.get(Calendar.MONTH);
		System.out.println(difInMonths);

	}

}
