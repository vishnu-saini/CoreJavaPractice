import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) {
		Set<Box> boxSet = new TreeSet<Box>();
		System.out.println("Enter the number of Box");
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			Box b = new Box();

			System.out.println("Enter the Box " + i + " details");
			System.out.println("Enter Length");
			double len = sc.nextDouble();
			System.out.println("Enter Width");
			double wid = sc.nextDouble();
			System.out.println("Enter Height");
			double hght = sc.nextDouble();
			b.setLength(len);
			b.setWidth(wid);
			b.setHeight(hght);
			boxSet.add(b);

		}
		System.out.println("Unique Boxes in the Set are");

		DecimalFormat df1 = new DecimalFormat("###.0#");
		for (Box boxx : boxSet) {
			System.out.println("Length ="
					+ boxx.getLength()
					+ " Width ="
					+ boxx.getWidth()
					+ " Height ="
					+ boxx.getHeight()
					+ " Volume ="
					+ df1.format(boxx.getLength() * boxx.getHeight()
							* boxx.getWidth()));

		}

	}
}
