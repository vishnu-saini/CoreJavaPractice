package conditionalStatement;

import java.util.Scanner;

public class GreenLight {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		float s,d,t,v;
		s=scanner.nextFloat();
		d=scanner.nextFloat();
		t=scanner.nextFloat();
		v=d*60*60/t;
		if(s >= v){
			System.out.println("yes");
		}else{
			System.out.println("no");
		}
	}

}
