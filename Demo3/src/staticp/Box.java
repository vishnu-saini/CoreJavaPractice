package staticp;

public class Box {
	private int length;
	private int width;
	private int height;
	public static int var = 3;

	Box() {

	}

	Box(int lenght, int width, int height) {
		this.length = lenght;
		this.width = width;
		this.height = height;

	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int area() {
		return 2 * (height * width + width * length + height * length);
	}

	public static void msg() {
		System.out.println("you have calculated area " + var);
	}

}
