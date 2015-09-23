import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a,b,i;
		Scanner scanner=new Scanner(System.in);
		a=scanner.nextInt();
		b=scanner.nextInt();
		for(i=a;i<=b;i++){
			if(( ((i/10) + (i%10)) + ((i/10)*(i%10))) == i){
				System.out.println(i);
			}
		}
	}

}