package loopingStatement;

import java.util.Scanner;

public class KidsHomeWork {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n,i;
		Scanner scanner=new Scanner(System.in);
		n=scanner.nextInt();
		for(i=0;i<n;i++){
			for(int j=0;j<=i;j++){
				System.out.print((i+1)+" ");
			}
			System.out.println();
		}
	}

}
