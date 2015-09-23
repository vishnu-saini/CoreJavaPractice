package ArrayString;

import java.util.Scanner;

public class CarryOperation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		long a,b;
		int carry=0,count=0;
		Scanner scanner=new Scanner(System.in);
		a=scanner.nextLong();
		b=scanner.nextLong();
		while(a>0 || b>0){
			if(((a%10)+(b%10)+carry) >9){
				count++;
				carry=(int) (((a%10)+(b%10)+carry)/10);
			}
			a=a/10;
			b=b/10;
		}
		System.out.println(count);
	}

}
