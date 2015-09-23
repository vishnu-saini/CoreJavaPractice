package com.vishnu.final_tute;

class Bike {
	final void run() {
		System.out.println("running");
	}
}

class Honda extends Bike {
	/*
	 * void run() { System.out.println("running safely with 100kmph"); } 
	 * 
	 * final method can not be inherited (compile time error)
	 */

}

class FinalMethod {
	public static void main(String args[]) {
		Honda honda = new Honda();
		honda.run();
	}
}