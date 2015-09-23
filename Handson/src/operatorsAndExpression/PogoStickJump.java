package operatorsAndExpression;

import java.util.Scanner;

public class PogoStickJump {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x,y,step;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the X and Y coordinate of friend's house");
		x=scanner.nextInt();
		y=scanner.nextInt();
		step =(int) Math.ceil(Math.sqrt((3-x)*(3-x)+(4-y)*(4-y)));
		System.out.println("Raju needs "+step+" jumps");
	}

}
