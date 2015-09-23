package inputAndOutputStatement;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Scanner;

public class Ttt3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		float a=scanner.nextFloat();
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		System.out.println("Harry has got :\nProf.Dumbledore must get the wand worth $"+df.format(a)+".");
	}

}
