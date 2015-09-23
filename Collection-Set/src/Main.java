import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;


public class Main {
public static void main(String[] args) {
	Scanner scanner=new Scanner(System.in);
	Map<String,Integer> map=new TreeMap<String, Integer>();
	String card;
	int number,count=0;
	for (int i = 0; i < 4; ) {
		count++;
		System.out.println("Enter a card :");
		card=scanner.nextLine();
		number=scanner.nextInt();
		scanner.nextLine();
		if(!map.containsKey(card)){
			map.put(card, number);
			i++;
		}
	}
	System.out.println("Four symbols gathered in "+count+" cards.");
	System.out.println("Cards in Set are :");
	for(String string:map.keySet()){
		System.out.println(string+" "+map.get(string));
	}
}
}
