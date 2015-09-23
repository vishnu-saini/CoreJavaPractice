package com.vishnu.test1;

import java.util.TreeSet;

class Student {
	String studentName;

	Student() {
	}

	Student(String studentName) {
		this.studentName = studentName;
	}

	public String toString() {
		return this.studentName;
	}
}

public class TestCol7 {
	public static void main(String args[]) {
		TreeSet students = new TreeSet();
		students.add(new Student("Raju"));
		students.add(new Student("Krishna"));
		students.add(new Student("Vijay"));
		System.out.println(students);
	}
}