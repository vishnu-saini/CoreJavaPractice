package ObjectandClass;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h, w, l;
		Scanner scanner = new Scanner(System.in);

		h = scanner.nextInt();
		w = scanner.nextInt();
		l = scanner.nextInt();
		Box b = new Box(l, w, h);

		System.out.println(b.getHeight() + " " + b.area());
	}

}
