import java.util.Scanner;

public class Demo {
	public static void main(String[] args) {
		Demo demo = new Demo();
		Scanner scanner = new Scanner(System.in);
		int area = demo.calculateArea(scanner.nextInt());
		System.out.println("the area is :");
		System.out.println(area);
	}

	public int calculateArea(int length) {
		return length * length;
	}
}
