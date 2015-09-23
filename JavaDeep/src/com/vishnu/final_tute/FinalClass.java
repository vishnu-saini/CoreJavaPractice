package com.vishnu.final_tute;

public class FinalClass {
	public static void main(String args[]) {
		Motercycle honda = new Motercycle();
		honda.run();
	}
}

final class Motercycle {
	void run(){
		System.out.println("running");
	}
}

/*
 * Final class can not be inherited (Compilation error)
 */

/*class Honda1 extends Motercycle {
	void run() {
		System.out.println("running safely with 100kmph");
	}

}*/