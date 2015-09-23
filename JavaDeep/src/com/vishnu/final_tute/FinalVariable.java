package com.vishnu.final_tute;
class FinalVariable {
	final int speedlimit;// final variable
	final int speedLowerLimit = 0;
	static final int average;
	

	FinalVariable() {
		speedlimit = 100;// only uninitialized final variable is allowed to
							// initialize
		/*
		 * speedLowerLimit=10;
		 * not allowed
		 */
	}

	static {
		average = 50; // blank static final variable is allowed to be initialize
						// in static block
	}

	static void start() {

		/* average=50; */// static final variable is not allowed to be
							// initialize in static function
		System.out.println("in start");
	}

	void run() {
		/*
		 * not allowed speedlimit=400;
		 */
		System.out.println(speedlimit);
		System.out.println(speedLowerLimit);
	}

	public static void main(String args[]) {
		FinalVariable obj = new FinalVariable();
		obj.run();
	}
}