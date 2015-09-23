package com.vishnu.test;

class Train {
	String name = "Shatapdhi";
}

class TestTrain {
	public static void main(String a[]) {
		Train t = new Train();
		System.out.println(t); // Line a
		System.out.println(t.toString()); // Line b
	}
}