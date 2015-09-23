package loopingStatement;

import java.util.Scanner;

public class Trendy {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		if(n/100 >= 1 && n/100 <=9 && ((n%100)/10)%3 == 0){
			System.out.println("Trendy Number");
		}else{
			System.out.println("Not a Trendy Number");
		}
	}

}
