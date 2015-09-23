public class CosClass extends Thread {
	private int degree;
	public double cosValue;

	CosClass(int degree) {
		this.degree = degree;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		super.run();
		cosValue = Math.cos(degree * Math.PI / 180);
	}
}
