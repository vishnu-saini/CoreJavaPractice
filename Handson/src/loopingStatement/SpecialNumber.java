package loopingStatement;

import java.util.Scanner;

public class SpecialNumber {
	public static void main(String[] args) {
		int a,b,i;
		Scanner scanner=new Scanner(System.in);
		a=scanner.nextInt();
		b=scanner.nextInt();
		for(i=a;i<=b;i++){
			if(((i/10) + (i%10) + (i/10)*(i%10)) == i){
				System.out.println(i+" ");
			}
		}
	}
}
