package com.vishnu.test;

public class Base {
	private static final int ID = 3;
	public String name;

	public void methodA(int nn) {
		final int serialN = 11;
		class inner {
			void showResult() {
				System.out.println("Rslt= " + ID);
				System.out.println(name);
				System.out.println(nn);
				System.out.println(serialN);
			}
		} // end class inner
		new inner().showResult();
	} // end methodA
	public static void main(String[] args) {
		Base b=new Base();
		b.methodA(10);
	}
}
