public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		if (args.length != 2) {
			System.out.println("Invalid Input");
		} else {
			System.out.println("The sum of " + args[0] + " and " + args[1]
					+ " is "
					+ (Integer.parseInt(args[0]) + Integer.parseInt(args[1])));
		}
	}

}
