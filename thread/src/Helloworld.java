public class Helloworld extends Thread {
	public void run() {

		for (int i = 0; i < 3; i++) {
			try {
				Thread.currentThread().sleep(1000);
				System.out.println("running method:" + Thread.currentThread()
						+ "," + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		// extends thread
		// create object for thread
		// call start

		Helloworld obj = new Helloworld();
		obj.start();

		for (int i = 0; i < 3; i++) {
			try {
				Thread.currentThread().sleep(1000);
				System.out.println("main method:" + Thread.currentThread()
						+ "," + i);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
