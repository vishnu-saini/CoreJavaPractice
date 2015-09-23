public class label {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int count = 0;
		sd: for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				count++;
				System.out.println(count);
				if (count == 15) {
					break sd;
				}
			}
		}
	}

}
