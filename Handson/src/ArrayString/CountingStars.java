package ArrayString;

import java.util.Scanner;

public class CountingStars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int r,c,a[][],q,b[][],sum;
		a=new int[50][50];
		b=new int[50][4];
		Scanner scanner=new Scanner(System.in);
		r=scanner.nextInt();
		c=scanner.nextInt();
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				a[i][j]=scanner.nextInt();
			}
		}
		q=scanner.nextInt();
		for (int i = 0; i < q; i++) {
			for (int j = 0; j < 4; j++) {
				b[i][j]=scanner.nextInt();
			}
		}
		for (int i = 0; i < q; i++) {
			sum=0;
			for (int j = b[i][0]-1; j < b[i][2]; j++) {
				for (int j2 = b[i][1]-1; j2 < b[i][3]; j2++) {
					sum+=a[j][j2];
				}
			}
			System.out.println(sum);
			
		}
		
	}

}
