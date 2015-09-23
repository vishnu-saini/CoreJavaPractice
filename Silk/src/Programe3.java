
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;



public class Programe3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner scanner=new Scanner(System.in);
		HashMap<Integer, String> map=new HashMap<Integer, String>();
		do{
			System.out.println("Enter key");
			Integer key=scanner.nextInt();
			scanner.nextLine();
			System.out.println("Enter value");
			String value=scanner.nextLine();
			map.put(key, value);			
			System.out.println("Enter yes for more values");
		}while(scanner.nextLine().toLowerCase().equals("yes"));
		int count=0;
		Set<Entry<Integer, String>> entrySet=map.entrySet();
		for (Entry<Integer, String> entry : entrySet) {
			if(entry.getKey()%4 != 0)
				count++;
		}
		System.out.println(count);
	}

}
