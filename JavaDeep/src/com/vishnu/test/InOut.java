package com.vishnu.test;

class InOut {
	String s = new String("Between");

	public void amethod(final int iArgs) {
		int iam;
		class Bicycle {
			public void sayHello() {
				System.out.println(s);
				System.out.println(iArgs);
			}
		}// End of bicycle class
		Bicycle b=new Bicycle();
		b.sayHello();

	}// End of amethod

	public void another() {
		int iOther;
	}
	public static void main(String[] args) {
		InOut io=new InOut();
		io.amethod(10);
	}
}