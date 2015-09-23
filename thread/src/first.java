public class first {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1" + Thread.currentThread().getName());
		System.out.println("2");
		System.out.println("3");
		System.out.println("4");
		System.out.println("5");
		System.out.println("6");
		method();
		System.out.println("11");
		System.out.println("12");
		System.out.println("13");
		System.out.println("14");
		System.out.println("15");

	}

	public static void method() {
		System.out.println("7");
		System.out.println("8");
		System.out.println("9");
		System.out.println("10");
	}
}
