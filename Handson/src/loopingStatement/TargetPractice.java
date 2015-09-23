package loopingStatement;

import java.util.Scanner;

public class TargetPractice {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner=new Scanner(System.in);
		int n,score=0,i,count=0;
		n=scanner.nextInt();
		while(score<n){
			i=scanner.nextInt();
			score=score+i;
			count++;
		}
		System.out.println("The number of turns is "+count);
		
	}

}
