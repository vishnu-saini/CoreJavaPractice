package com.vishnu.test;

public class TThread implements Runnable {
	public void run() {
		try {
			Thread.sleep(100000);
		} catch (Exception objE) {
			System.out.println("Exception Handler");
		}
		System.out.println("Run method ends here");
	}

	public static void main(String[] argv) {
		Thread thread = new Thread(new TThread());
		thread.start();
		thread.interrupt();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Main method ends here");
	}
}