public class Problem10 {
	public static void main(String[] args) {
		int a[] = { 1, 2, 3, 4, 5 };
		int b[] = { 6, 7, 8, 9, 10 };
		int c[] = alternativeIndicesElements(a, b);
		for (int d : c)
			System.out.println(d);
	}

	public static int[] alternativeIndicesElements(int[] a, int[] b) {
		int c[] = new int[a.length];
		for (int i = 0; i < b.length; i++) {
			if (i % 2 == 0) {
				c[i] = b[i];
			} else {
				c[i] = a[i];
			}
		}
		return c;
	}
}