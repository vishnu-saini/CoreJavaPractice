package staticp;

import java.util.Scanner;

public class Main {
	int a = 10;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int h, w, l;
		Scanner scanner = new Scanner(System.in);
		Main m = new Main();
		Box b = new Box();
		b.var++;
		Box b1 = new Box();
		b1.var++;

		System.out.println(b.var);
		System.out.println(b1.var);
		System.out.println(Box.var);
		b.msg();
		b1.msg();
		Box.msg();
		Box.msg();
		int r = 10 * m.a;
		System.out.println("area of circcle is " + getDoubleOfPi() * r);

		/* System.out.println(b.getHeight() + " " + b.area()); */
	}

	public static double getDoubleOfPi() {
		return 3.14 * 2;
	}

}
