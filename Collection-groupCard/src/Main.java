import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) {
		
		int noOfCards,number,count,sum;
		char symbol;
		boolean flag=true;
		TreeMap<Character, ArrayList<Card>> map=new TreeMap<Character, ArrayList<Card>>();
		
		Scanner scanner=new Scanner(System.in);
		System.out.println("Enter Number of Cards : ");
		noOfCards=scanner.nextInt();
		scanner.nextLine();
		for (int i = 0; i < noOfCards; i++) {
		
			System.out.println("Enter card "+(i+1)+":");
			symbol=scanner.nextLine().charAt(0);
			number=scanner.nextInt();
			scanner.nextLine();
			Set<Character> keysOfMap=map.keySet();
			if(keysOfMap.contains(symbol)){
				ArrayList<Card> cardsAtKey=map.get(symbol);
				Card card=new Card(symbol,number);
				cardsAtKey.add(card);
			}else {
				ArrayList<Card> cardsList=new ArrayList<Card>();
				Card card=new Card(symbol, number);
				cardsList.add(card);
				map.put(symbol, cardsList);
			}
		}
		
		Set<Character> keysOfMap=map.keySet();
		System.out.println("Distinct Symbols are : ");
		for (Character character : keysOfMap) {
			System.out.print(character+ " ");
		}
		System.out.println();
		for (Character character : keysOfMap) {
			count=0;
			sum=0;
			System.out.println("Cards in "+character+" Symbol");
			ArrayList<Card> cardList=map.get(character);
			for (Card card : cardList) {
				System.out.println(card.getSymbol()+" "+card.getNumber());
				count++;
				sum+=card.getNumber();
			}
			System.out.println("Number of cards : "+count);
			System.out.println("Sum of Numbers : "+sum);
		}
		
		
		
	}
}
