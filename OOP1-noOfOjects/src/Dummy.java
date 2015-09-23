
public class Dummy {
	private int a;
	private static int count=0;
	public Dummy() {
		count++;
	}
	public Dummy(int a){
		this.a=a;
		count++;
	}
	public static int getCount() {
		return count;
	}
	public static void setCount(int count) {
		Dummy.count = count;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	void display(){
		System.out.println("The value of a is "+a);
		System.out.println("The number of objects created is "+count);
	}
}
