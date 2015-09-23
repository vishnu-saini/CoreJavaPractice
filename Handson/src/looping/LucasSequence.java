package looping;

import java.util.Scanner;

public class LucasSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,i,x=0,y=0,z=1,temp;
		Scanner scanner=new Scanner(System.in);
		a=scanner.nextInt();
		if(a==1){
			System.out.println(z+" ");
		}else if (a==2) {
			System.out.println(x+" "+y+" ");
		}else if (a>=3) {
			System.out.println(x+" "+y+" "+z+" ");
			i=3;
			while(i<a){
				temp=x+y+z;
				y=z;
				x=y;
				z=temp;
				System.out.println(z+" ");
				i++;
			}
		}
		
	}

}
