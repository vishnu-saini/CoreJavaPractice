public class TanClass extends Thread {
	private int degree;
	public double tanValue;

	TanClass(int degree) {
		this.degree = degree;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		tanValue = Math.tan(degree * Math.PI / 180);
	}
}
