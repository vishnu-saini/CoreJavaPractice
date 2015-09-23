package com.vishnu.test;

class AThread extends Thread {
	private int i;

	public void run() {
		i = 1;
	}

	public static void main(String[] args) {
		AThread a = new AThread();
		a.start();
		System.out.print(a.i);
	}
}
