package conditionalStatement;

import java.text.DecimalFormat;
import java.util.Scanner;

public class ProfitLoss {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String studentType;
		float tutionFee,busFee,hostelFee,totalFee=0;
		Scanner scanner = new Scanner(System.in);
		DecimalFormat df = new DecimalFormat();
		df.setMaximumFractionDigits(0);
		df.setMinimumFractionDigits(0);

		System.out.println("Enter the student type");
		studentType=scanner.nextLine();
		System.out.println("Enter tuition fee");
		tutionFee=scanner.nextFloat();
		System.out.println("Enter bus fee");
		busFee=scanner.nextFloat();
		System.out.println("Enter hostel fee");
		hostelFee=scanner.nextFloat();
		if(studentType == "MSDS"){
			totalFee=tutionFee+busFee;
		}else if(studentType == "MSH"){
			totalFee=tutionFee+hostelFee;
		}else if (studentType == "MGSDS") {
			totalFee=(float) (1.5*tutionFee+busFee);
		}else if (studentType == "MGSH") {
			totalFee=(float)(1.5*tutionFee+hostelFee);
		}
		System.out.println("The fees to be paid by the student is Rs."+df.format(totalFee));

	}

}
