public class Main {
	public static void main(String[] args) {

		System.out.println("The number of arguments passed is " + args.length);

		if (args.length != 0) {
			System.out.println("The command line arguments passed are");

			for (int i = 0; i < args.length; i++) {
				System.out.println(args[i]);
			}
		}
	}
}
