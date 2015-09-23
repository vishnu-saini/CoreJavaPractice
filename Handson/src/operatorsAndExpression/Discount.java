package operatorsAndExpression;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Discount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		float item1,item2,discountPercent,total,discount,save;
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Price of item 1 :");
		item1=scanner.nextFloat();
		System.out.println("Price of item 2 :");
		item2=scanner.nextFloat();
		System.out.println("Discount in percentage :");
		discountPercent=scanner.nextFloat();
		total=item1+item2;
		save=(float) (total/10.0);
		discount=total-save;
		System.out.format("Total amount : $%.2f",total);
		System.out.format("Discounted amount : $%.2f",discount);
		System.out.format("Saved amount : $%.2f",save);
		
	}
}
