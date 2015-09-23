package com.vishnu.test;

public class UnwiseThreads implements Runnable {
	public void run() {
		while (true) {
			System.out.println("a");
		}
	}

	public static void main(String args[]) {
		UnwiseThreads ut1 = new UnwiseThreads();
		UnwiseThreads ut2 = new UnwiseThreads();
		UnwiseThreads ut3 = new UnwiseThreads();
		ut1.run();
		ut2.run();
		ut3.run();
	}
}