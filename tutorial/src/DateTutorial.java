import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class DateTutorial {
	public static void main(String[] args) {
		Date date = null;
		Date aajKiDate = new Date();
		System.out.println(aajKiDate);
		Scanner scanner = new Scanner(System.in);
		String str = scanner.nextLine();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		sdf.setLenient(false);
		try {
			date = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Calendar now = Calendar.getInstance();
		Calendar dob = Calendar.getInstance();
		dob.setTime(date);
		System.out.println(dob.getActualMaximum(Calendar.DAY_OF_MONTH));
		now.setTime(aajKiDate);
		if (dob.after(now)) {
			throw new IllegalArgumentException("Can't be born in the future");
		}
		int year2 = now.get(Calendar.YEAR);
		int year1 = dob.get(Calendar.YEAR);
		int age = year2 - year1;

		int month2 = now.get(Calendar.MONTH);
		int month1 = dob.get(Calendar.MONTH);
		if (month1 > month2) {
			age--;
		} else if (month1 == month2) {
			int day2 = now.get(Calendar.DAY_OF_MONTH);
			int day1 = dob.get(Calendar.DAY_OF_MONTH);
			if (day1 > day2) {
				age--;
			}
		}
		System.out.println(age);

		/*
		 * System.out.println(date); System.out.println(date.getDate());
		 * System.out.println(date.getDay());
		 * System.out.println(date.getHours());
		 * System.out.println(date.getMinutes());
		 * System.out.println(date.getMonth());
		 * System.out.println(date.getSeconds());
		 * System.out.println(date.getTime());
		 * System.out.println(date.getTimezoneOffset());
		 * System.out.println(date.getYear());
		 */}

}
