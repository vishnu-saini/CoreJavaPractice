package com.vishnu.test;

class A {
}

class B extends A {
}

public class Code2 {
	public void method(A a) {
		System.out.println("A");
	}

	public void method(B b) {
		System.out.println("B");
	}

	public static void main(String args[]) {
		new Code2().method(new Object());
	}
}