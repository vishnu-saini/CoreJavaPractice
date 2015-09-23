package com.vishnu.test;

import java.io.*;

class Test {
	int a = 10;
	public void start(){
		a=50;
	}
}

class Test2 extends Test implements Serializable {
	int b;

	public String toString() {
		return "a = " + a + ", " + "b = " + b;
	}
	
	public void start2(){
		b=50;
	}
}

public class IOCode5 {
	public static void main(String args[]) throws FileNotFoundException,
			IOException, ClassNotFoundException {
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
				"D:/ObjectData"));
		Test2 t1 = new Test2();
		t1.a = 20;
		t1.b = 30;
		t1.start();
		System.out.println(t1);
		out.writeObject(t1);
		out.close();
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(
				"D:/ObjectData"));
		Test2 t2 = (Test2) in.readObject(); // Line 1
		System.out.println(t2);
	}
}