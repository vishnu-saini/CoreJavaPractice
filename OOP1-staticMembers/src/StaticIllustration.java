
public class StaticIllustration {
	private int i1;
	private static int i2;
	public int getI1() {
		return i1;
	}
	public void setI1(int i1) {
		this.i1 = i1;
	}
	public static int getI2() {
		return i2;
	}
	public static void setI2(int i2) {
		StaticIllustration.i2 = i2;
	}
	
	public String toString(){
		return "i1 = "+i1+",i2 = "+i2;
		
	}
}
