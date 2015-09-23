package com.vishnu.test;

class RE {
	public static void main(String args[]) {
		try {
			String s = null;
			System.out.println(s.length());
		} catch (NullPointerException npe) {
			System.out.println("NullPointerException handled");
			throw new Exception(npe.getMessage());
		}
	}
}