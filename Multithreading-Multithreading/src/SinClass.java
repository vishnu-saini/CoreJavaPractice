public class SinClass extends Thread {
	private int degree;
	public double sinValue;

	SinClass(int degree) {
		this.degree = degree;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		sinValue = Math.sin(degree * Math.PI / 180);
	}
}
