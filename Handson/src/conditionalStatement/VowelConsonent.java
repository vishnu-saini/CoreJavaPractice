package conditionalStatement;

import java.util.Scanner;

public class VowelConsonent {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char a;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a character");
		a=scanner.nextLine().charAt(0);
		if( a=='a' || a=='e' || a=='i' || a=='o' || a=='u' || a=='A' || a=='E' || a=='I' || a=='O' || a=='U'){
			System.out.println("Vowel");
		}else if( (a>=65 && a<=91) || (a>=97 && a<=123)){
			System.out.println("Consonant");
		}else{
			System.out.println("Not an alphabet");
		}
	}

}
