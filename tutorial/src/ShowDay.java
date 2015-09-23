import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShowDay {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "06-02-2015";
		SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");
		Date d = null;

		try {
			d = sdf.parse(str);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		SimpleDateFormat sdf1 = new SimpleDateFormat("EEE, MMM d, ''yy");
		String vaar = sdf1.format(d);
		System.out.println(vaar);
		sdf1 = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");
		vaar = sdf1.format(d);
		System.out.println(vaar);
		sdf1 = new SimpleDateFormat("EEE, MMM d, ''yy");
		vaar = sdf1.format(d);
		System.out.println(vaar);
		sdf1 = new SimpleDateFormat("h:mm a");
		vaar = sdf1.format(d);
		System.out.println(vaar);
		sdf1 = new SimpleDateFormat("hh 'o''clock' a, zzzz");
		vaar = sdf1.format(d);
		System.out.println(vaar);
		sdf1 = new SimpleDateFormat("K:mm a, z");
		vaar = sdf1.format(d);
		System.out.println(vaar);
		sdf1 = new SimpleDateFormat("yyyyy.MMMMM.dd GGG hh:mm aaa");
		vaar = sdf1.format(d);
		System.out.println(vaar);
		sdf1 = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss Z");
		vaar = sdf1.format(d);
		System.out.println(vaar);
		sdf1 = new SimpleDateFormat("yyMMddHHmmssZ");
		vaar = sdf1.format(d);
		System.out.println(vaar);
		sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		vaar = sdf1.format(d);
		System.out.println(vaar);

	}
}
