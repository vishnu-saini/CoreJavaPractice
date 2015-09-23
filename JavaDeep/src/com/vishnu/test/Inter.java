package com.vishnu.test;

interface i1 {
	int i = 0;
}

interface i2 {
	int i = 0;
}

class inter implements i1, i2 {
	public static void main(String[] a) {
		System.out.println(i);
	}
}