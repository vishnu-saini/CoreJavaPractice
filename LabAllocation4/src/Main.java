

import java.util.Scanner;

public class Main {

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
		diff=noOfStudent;
		int lab=0;
		for(int i=0;i<3;i++){
			if(noOfStudent <= capicity[i]){
				positiveFlag=true;
				currentDiff=capicity[i]-noOfStudent;
				if(currentDiff<diff){
					diff=currentDiff;
					lab=i;
				}
			}
		}
		
		if(!positiveFlag){
			System.out.println("None of the labs can be allocated");
		}else{
			System.out.println("L"+(lab+1)+" should be allocated to this class");
		}
	}

}
