package operatorsAndExpression;

import java.text.DecimalFormat;
import java.util.Scanner;

public class RadiusOfCircle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,c;
		float k,radius;
		Scanner scanner = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		
		System.out.println("Enter the sides of a triangle");
		a=scanner.nextInt();
		b=scanner.nextInt();
		c=scanner.nextInt();
		k=(a+b+c)/2;
		
		radius= (float) ((Math.sqrt(k*(k-a)*(k-b)*(k-c)))/k);
		System.out.println("The radius of the circle is "+df.format(radius));
	}

}
