import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String dicision;
		int i=1;
		Scanner scanner=new Scanner(System.in);
		Dummy dummy;
		
		do{
			
			System.out.println("Enter Object "+i+" \"a\" value");
			dummy=new Dummy(scanner.nextInt());
			scanner.nextLine();
			System.out.println("Object "+i+" details");
			dummy.display();
			System.out.println("Do you want to create another object? Type yes or no (not case sensitive)");
			dicision=scanner.nextLine();
			i++;
		}while(dicision.equalsIgnoreCase("yes"));
		System.out.println("The number of objects created so far is "+dummy.getCount());
	}

}
