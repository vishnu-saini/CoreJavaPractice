package abstractp;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bank b = new Sbi();// if object is PNB, method of PNB will be invoked
		int interest = b.getRateOfInterest();
		Bank p = new Pnb();
		int interest1 = p.getRateOfInterest();
		System.out.println("Rate of Interest is: " + interest + " %");
		System.out.println("Rate of Interest is: " + interest1 + " %");
		b.getName();
		p.getName();
	}

}
