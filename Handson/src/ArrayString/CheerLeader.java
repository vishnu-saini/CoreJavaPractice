package ArrayString;

import java.util.Scanner;

public class CheerLeader {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		Scanner scanner= new Scanner(System.in);
		n=scanner.nextInt();
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if((i==j || i==(n-j-1))){
					System.out.print("M");
				}else if(i==0 || j==0 || i==(n-1) || j==(n-1)){
					System.out.print("F");
				}else{
					System.out.print("C");
				}
			}
			System.out.println();
		}
	}

}
