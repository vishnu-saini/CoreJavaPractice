import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		double sum;
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Degree for Sin : ");
		SinClass sin = new SinClass(scanner.nextInt());
		System.out.println("Enter the Degree for Cos : ");
		CosClass cos = new CosClass(scanner.nextInt());
		System.out.println("Enter the Degree for Tan : ");
		TanClass tan = new TanClass(scanner.nextInt());

		sin.start();
		cos.start();
		tan.start();
		try {
			sin.join();
			cos.join();
			tan.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sum = ((int) Math
				.round((sin.sinValue + cos.cosValue + tan.tanValue) * 100)) / 100.0;
		System.out.println("Sum of sin, cos, tan = " + sum);
	}
}
