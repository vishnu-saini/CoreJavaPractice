import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		Set<Card> cardSet = new HashSet<Card>();
		int number, count = 0;
		char symbol;
		for (int i = 0; i < 4; i++) {

			count++;
			System.out.println("Enter a card :");
			symbol = scanner.nextLine().charAt(0);
			number = scanner.nextInt();
			scanner.nextLine();

			Card card = new Card();

			if (cardSet.co)
				if (!map.containsKey(card)) {
					map.put(card, number);
					i++;
				}
		}
		System.out.println("Four symbols gathered in " + count + " cards.");
		System.out.println("Cards in Set are :");
		for (String string : map.keySet()) {
			System.out.println(string + " " + map.get(string));
		}
	}
}
