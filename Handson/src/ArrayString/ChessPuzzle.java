package ArrayString;

import java.util.Scanner;

public class ChessPuzzle {

	public static void main(String args[]){

			// TODO Auto-generated method stub
			int row[],column[],n;
			boolean flag=true;
			row= new int[8];
			column=new int[8];
			Scanner scanner=new Scanner(System.in);
			n=scanner.nextInt();
			for (int i = 0; i < n; i++) {
				row[i]=scanner.nextInt();
				column[i]=scanner.nextInt();
			}
			rowCheck:
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					if(row[i] == row[j]){
						flag = false;
						break rowCheck;
					}
				}
			}
			columnCheck:
			for (int i = 0; i < n; i++) {
				for (int j = i+1; j < n; j++) {
					if(column[i] == column[j]){
						flag = false;
						break columnCheck;
					}
				}
			}
			if(flag== true){
				System.out.println("SAFE");
			}else {
				System.out.println("NOT SAFE");
			}
	}
}
