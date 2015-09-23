package conditionalStatement;

import java.util.Scanner;

public class LabAllocation4 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int noOfStudent,diff=0,currentDiff,capicity[];
		boolean positiveFlag=false;
		capicity=new int[3];
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter x");
		capicity[0]=scanner.nextInt();
		System.out.println("Enter y");
		capicity[1]=scanner.nextInt();
		System.out.println("Enter z");
		capicity[2]=scanner.nextInt();
		System.out.println("Enter n");
		noOfStudent=scanner.nextInt();
		
		for(int i=0;i<3;i++){
			if(noOfStudent <= capicity[i]){
				positiveFlag=true;
				currentDiff=capicity[i]-noOfStudent;
				if(currentDiff<diff){
					diff=i;
				}
			}
		}
		
		if(!positiveFlag){
			System.out.println("None of the labs can be allocated");
		}else{
			System.out.println("L"+(diff+1)+" should be allocated to this class");
		}
	}

}
