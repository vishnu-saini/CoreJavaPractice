package operatorsAndExpression;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Average {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int oversBowled,target;
		float currentRunrate,requiredRunrate;
		
		Scanner scanner = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		
		
		System.out.println("Enter the number of overs bowled so far");
		oversBowled=scanner.nextInt();
		System.out.println("Enter the current run rate");
		currentRunrate=scanner.nextFloat();
		System.out.println("Enter the target score");
		target=scanner.nextInt();
		
		requiredRunrate= (target-(currentRunrate*oversBowled))/(50-oversBowled);
		
		System.out.println("Required run rate is "+df.format(requiredRunrate));
	}

}
