import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input,toFind;
		char toFindUpper,toFindLower;
		int count=0;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the file name");
		input = scanner.nextLine();
		System.out.println("Enter the character to be counted");
		toFind=scanner.nextLine();
		toFindUpper=toFind.toUpperCase().charAt(0);
		toFindLower=toFind.toLowerCase().charAt(0);
	
		try {
			FileReader fr = new FileReader(new File(input));
			int k;
			while ((k = fr.read()) != -1) {
				if(k == toFindLower || k ==  toFindUpper){
					count++;
				}
			}
			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("File '"+input+"' has "+count+" instances of letter '"+toFind+"'.");

	}

}
