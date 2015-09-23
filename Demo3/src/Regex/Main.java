package Regex;

import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);

		String str = scanner.nextLine();

		/*
		 * str = str.replaceAll("[a].[b]", "vishnu"); str =
		 * str.replaceAll("[a]..[b]", "vishnu"); str =
		 * str.replaceAll("[a].*[b]", "vishnu"); str = str.replaceAll("^w",
		 * "what"); str = str.replaceAll("w$", "what");
		 * 
		 * str = str.replaceAll("[0-9]{2}[/]{1}[0-9]{2}[/][0-9]{4}", "date");
		 * str = str.replaceAll("[a-zA-Z0-9.]*[@]{1}[a-zA-B]*[.][a-zA-Z]*",
		 * "email");
		 */
		str = str.replaceAll("\\s+", " ");
		System.out.println(str);

	}
}
