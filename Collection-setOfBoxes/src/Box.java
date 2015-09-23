public class Box implements Comparable<Box> {
	private Double length;
	private Double width;
	private Double height;

	public Box() {
		// TODO Auto-generated constructor stub
	}

	public Box(Double length, Double width, Double height) {
		super();
		this.length = length;
		this.width = width;
		this.height = height;
	}

	public Double getLength() {
		return length;
	}

	public void setLength(Double length) {
		this.length = length;
	}

	public Double getWidth() {
		return width;
	}

	public void setWidth(Double width) {
		this.width = width;
	}

	public Double getHeight() {
		return height;
	}

	public void setHeight(Double height) {
		this.height = height;
	}

	@Override
	public int hashCode() {

		return (int) (width * height * length * 10000);
	}

	// @Override
	// public boolean equals(Object obj) {
	// if (this == obj)
	// return true;
	// if (obj == null)
	// return false;
	// if (getClass() != obj.getClass())
	// return false;
	// Box other = (Box) obj;
	// if (height == null) {
	// if (other.height != null)
	// return false;
	// }
	// if (length == null) {
	// if (other.length != null)
	// return false;
	// }
	// if (width == null) {
	// if (other.width != null)
	// return false;
	// }
	//
	// Double volume = new Double(height * width * length);
	// Double volume1 = new Double(other.length * other.height * other.width);
	//
	// if (!volume.equals(volume1))
	// return false;
	// return true;
	// }

	public int compareTo(Box other) {
		// long res = Double.doubleToLongBits(height)
		// * Double.doubleToLongBits(length)
		// * Double.doubleToLongBits(width);
		// long res1 = Double.doubleToLongBits(other.height)
		// * Double.doubleToLongBits(other.length)
		// * Double.doubleToLongBits(other.width);
		// int x = 0;
		// if (res < res1)
		// x = 1;
		// else if (res > res1)
		// x = -1;

		return hashCode() - other.hashCode();
	}
}