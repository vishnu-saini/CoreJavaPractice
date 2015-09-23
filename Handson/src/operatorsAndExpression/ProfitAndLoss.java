package operatorsAndExpression;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ProfitAndLoss {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int dozen;
		float profit,costPrice,sellingPrice,dozenPrice;
		
		Scanner scanner = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		
		
		System.out.println("Enter the number of dozens of toys purchased");
		dozen=scanner.nextInt();
		System.out.println("Enter the price per dozen");
		dozenPrice=scanner.nextInt();
		System.out.println("Enter the selling price of 1 toy");
		sellingPrice=scanner.nextInt();
		
		costPrice=dozenPrice/12;
		profit=(sellingPrice-costPrice)*100/(costPrice);
		
		System.out.println("Sam's profit percentage is "+df.format(profit)+" percent");

	}
	
}
