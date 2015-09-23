import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/*1) Given a method with a date string in format dd/mm/yyyy.
 Write code to validate the given date against the given formate.
 if it is a valid date return 1 else return -1.
 Example1:
 Input= 12/06/1987
 output=1
 Example1:
 Input= 03/1/1987
 output=-1*/
public class Programe1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String s1=scanner.nextLine();
		
		if (s1.matches("[0-9]{2}[/]{1}[0-9]{2}[/]{1}[0-9]{4}")) {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
			sdf.setLenient(false);
			try {
				Date d1 = sdf.parse(s1);
				System.out.println(1);
			} catch (ParseException e) {
				System.out.println(-1);
			}
		} else
			System.out.println(-1);
	}

}
