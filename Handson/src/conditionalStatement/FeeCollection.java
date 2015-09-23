package conditionalStatement;

import java.text.DecimalFormat;
import java.util.Scanner;

public class FeeCollection {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String studentType;
		float tutionFee,busFee,hostelFee,totalFee=0;
		Scanner scanner=new Scanner(System.in);
		DecimalFormat df = new DecimalFormat("###.##");
		df.setMaximumFractionDigits(2);
		df.setMinimumFractionDigits(2);
		
		System.out.println("Enter the student type");
		studentType=scanner.nextLine();
		System.out.println("Enter tuition fee");
		tutionFee=scanner.nextFloat();
		System.out.println("Enter bus fee");
		busFee=scanner.nextFloat();
		System.out.println("Enter hostel fee");
		hostelFee=scanner.nextFloat();
		
		if(studentType.equals("MSDS")){
			totalFee=tutionFee+busFee;
		}else if (studentType.equals("MSH")) {
			totalFee=tutionFee+hostelFee;
		}else if (studentType.equals("MGSDS")) {
			totalFee=(float) (1.5*tutionFee+busFee);
		}else if (studentType.equals("MGSH")) {
			totalFee=(float) (1.5*tutionFee+hostelFee);
		}
		
		
		System.out.println("The fees to be paid by the student is Rs."+df.format(totalFee));
		
	}

}
