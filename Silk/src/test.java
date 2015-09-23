import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

class test {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str1 = "12/12/1999 09:30:56 AM";
		String str2 = "19/12/1999 09:30:56 AM";
		Date date1 = null;
		Date date2 = null;
		SimpleDateFormat sd = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss a");
		try {

			date1 = sd.parse(str1);
			date2 = sd.parse(str2);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Calendar cal1 = Calendar.getInstance();
		cal1.setTime(date1);
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date2);
		// Time Difference Calculations Begin
		long milliSec1 = cal1.getTimeInMillis();
		long milliSec2 = cal2.getTimeInMillis();

		long timeDifInMilliSec;
		if (milliSec1 >= milliSec2) {
			timeDifInMilliSec = milliSec1 - milliSec2;
		} else {
			timeDifInMilliSec = milliSec2 - milliSec1;
		}

		long timeDifSeconds = timeDifInMilliSec / 1000;
		long timeDifMinutes = timeDifInMilliSec / (60 * 1000);
		long timeDifHours = timeDifInMilliSec / (60 * 60 * 1000);
		long timeDifDays = timeDifInMilliSec / (24 * 60 * 60 * 1000);

		System.out
				.println("Time differences expressed in various units are given below");
		System.out.println(timeDifInMilliSec + " Milliseconds");
		System.out.println(timeDifSeconds + " Seconds");
		System.out.println(timeDifMinutes + " Minutes");
		System.out.println(timeDifHours + " Hours");
		System.out.println(timeDifDays + " Days");
	}
}