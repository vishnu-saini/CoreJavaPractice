package com.vishnu.test;

class Test1 {
	Test1(int i) {
		System.out.println("Test1(" + i + ")");
	}
}

public class Question {
	static Test1 t1 = new Test1(1);
	Test1 t2 = new Test1(2);
	static Test1 t3 = new Test1(3);

	public static void main(String[] args) {
		Question Q = new Question();
	}
}