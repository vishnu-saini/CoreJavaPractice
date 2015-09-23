package com.vishnu.test;

public class WrapIt {
	public static void main(String[] args) {
		new WrapIt().testC('a');
	}

	public void testC(char ch) {
		Integer ss = new Integer(ch);
		Character cc = new Character(ch);
		System.out.println(ss);
		System.out.println(cc);
		if (ss.equals(cc))
			System.out.print("equals ");
		if (ss.intValue() == cc.charValue()) {
			System.out.println("EQ");
		}
	}
}