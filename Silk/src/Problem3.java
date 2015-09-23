import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Problem3 {
	public static void main(String[] args) {

		Date date = new Date();
		System.out.println(date);

		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		cal.add(Calendar.YEAR, 1);

		Calendar ca = new GregorianCalendar(2016, Calendar.FEBRUARY, 03);

		System.out.println(ca.getActualMaximum(Calendar.DATE));
	}

}
