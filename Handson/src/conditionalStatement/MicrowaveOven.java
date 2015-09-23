package conditionalStatement;

import java.util.Scanner;

public class MicrowaveOven {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int item;
		float heatingTime;
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter the number of items");
		item=scanner.nextInt();
		System.out.println("Enter the single item heating time");
		heatingTime=scanner.nextFloat();
		if(item==2){
			heatingTime=(float) (heatingTime*1.5);
		}else if (item == 3) {
			heatingTime=heatingTime*2;
		}
		
		if(item > 3){
			System.out.println("Number of items is more ");
		}else {
			System.out.format("The recommended heating time is %.2f",heatingTime);
		}
	}

}
