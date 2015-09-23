package ArrayString;

import java.util.Scanner;

public class MagicNumber {

	public static void main(String args[]){
		int a,b;
		Scanner scanner=new Scanner(System.in);
		a=scanner.nextInt();
		outerloop:
		while(true){
			a++;
			b=a;
			while(b>0){
				int remeinder=b%10;
				b/=10;
				if(remeinder != 7 && remeinder != 4){
					break;
				}
				if(b==0){
					break outerloop;
				}
				
			}
		}
		System.out.println(a);
	}
}
