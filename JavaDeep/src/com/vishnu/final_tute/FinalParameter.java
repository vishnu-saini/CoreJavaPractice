package com.vishnu.final_tute;

public class FinalParameter {
	void cube(final int n) {
		// can't be changed as n is final
		/* n=n+2; */
		// compile time error
		System.out.println(n);
	}

	public static void main(String args[]) {
		FinalParameter b = new FinalParameter();
		b.cube(5);
	}
}
