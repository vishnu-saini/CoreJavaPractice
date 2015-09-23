package ArrayString;

import java.util.Scanner;

public class Statues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,a[],i,sum=0,statueInEachRoom,move=0;
		a=new int[50];
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		for(i=0;i<n;i++){
			a[i]=scanner.nextInt();
			sum=sum+a[i];
		}
		statueInEachRoom=sum/n;
		for(i=0;i<n;i++){
			if(a[i]>statueInEachRoom){
				move+=a[i]-statueInEachRoom;
			}
		}
		System.out.println(move);
	}

}
