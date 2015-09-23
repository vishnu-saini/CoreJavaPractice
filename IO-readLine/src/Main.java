import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input;
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the file name");
		input = scanner.nextLine();
	
		try {
			FileReader fr = new FileReader(new File(input));
			BufferedReader reader = new BufferedReader(fr);
			String line = reader.readLine();

			while (line != null) {
				// Print read line
				System.out.println(line);

				// Read next line for while condition
				line = reader.readLine();
			}

			fr.close();

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
