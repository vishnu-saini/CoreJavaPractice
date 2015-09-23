import java.util.Scanner;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		StaticIllustration staticIllustration=new StaticIllustration();
		System.out.println("Enter Object 1 details");
		System.out.println("Enter i1");
		staticIllustration.setI1(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Enter i2");
		staticIllustration.setI2(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Object 1 Details : "+staticIllustration.toString());
		
		System.out.println("Enter Object 2 details");
		StaticIllustration staticIllustration1=new StaticIllustration();
		System.out.println("Enter i1");
		staticIllustration1.setI1(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Enter i2");
		staticIllustration1.setI2(scanner.nextInt());
		scanner.nextLine();
		System.out.println("Object 2 Details : "+staticIllustration1.toString());
		System.out.println("Object 1 Details : "+staticIllustration.toString());
		
	}

}
