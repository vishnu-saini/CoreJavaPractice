package looping;

import java.util.Scanner;

public class Factorial {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,i=0;
		Scanner scanner=new Scanner(System.in);
		a=scanner.nextInt();
		
		while(fact(i)<=a){
			i++;
		}
		i--;
		if(fact(i)==a){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
		
	}
	
	public static int fact(int n){
		int i=0,fact=1;
		while(i<=n){
			if(i==0 || i==1){
				fact=1;
			}else{
				fact=fact*i;
			}
			i++;
		}
		
		return fact;
	}

}
