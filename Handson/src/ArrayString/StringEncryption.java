package ArrayString;

import java.util.Scanner;

public class StringEncryption {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str;
		boolean flag;
		int count=0,index=0;
		char a[]=new char[50];
		int b[]=new int[50];
		Scanner scanner=new Scanner(System.in);
		str= scanner.nextLine();
		char[] charArray = str.toCharArray();
		
		for (int i = 0; i < charArray.length; i++) {
			flag=true;
			for (int j = 0; j < count; j++) {
				if(a[j] == charArray[i]){
					flag=false;
					index=j;
					break;
				}
			}
			if(flag){
				
				a[count]=charArray[i];
				b[count]=1;
				count++;
			}else{
			
				b[index]++;
			}
			
		}
		for (int i = 0; i < count; i++) {
			System.out.print(""+a[i]+b[i]);
		}
	}

}
