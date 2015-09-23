package loopingStatement;

import java.util.Scanner;

public class Fibonacci {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,i=0,j=1,temp,flag=0;
		Scanner scanner=new Scanner(System.in);
		a=scanner.nextInt();
		if(a==i || a==j){
			flag=1;
		}
		while(j<a){
			temp=j;
			j=i+j;
			i=temp;
			if(j==a){
				flag=1;
			}
		}
		if(flag==1){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}

}
