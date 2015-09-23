package operatorsAndExpression;

import java.text.DecimalFormat;
import java.util.Scanner;

public class TimeAndWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dayDifference;
		float timea,timeb,oneDayWork,timeTakenToComplete;
		
		Scanner scanner = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("###.##");
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		
		
		System.out.println("Enter the value of x");
		dayDifference=scanner.nextInt();
		timea=(3*dayDifference)/2;
		timeb=(dayDifference)/2;
		oneDayWork=((1/timea)+(1/timeb));
		timeTakenToComplete=1/oneDayWork;
		
	
		System.out.println("Working together, A and B can complete the work in "+df.format(timeTakenToComplete)+" days" );
	}

}
