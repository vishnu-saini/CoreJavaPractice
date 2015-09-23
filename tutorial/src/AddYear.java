import java.text.SimpleDateFormat;
import java.util.Date;

public class AddYear {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Date aajKiDate = new Date();
		aajKiDate.setYear(aajKiDate.getYear() + 2);
		System.out.println(aajKiDate);

		SimpleDateFormat sdf = new SimpleDateFormat("EEEE");

	}

}
