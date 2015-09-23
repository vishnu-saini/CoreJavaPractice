package com.vishnu.test;
class UserDefinedException extends Error { }
public class TasteIt {
	public static void main(String args[]) {
		try {
			try {
				throw new Error();
			} catch (UserDefinedException u1) {
				throw u1;
			} catch (Exception e1) {
				System.out.println("This is the required output");
			} finally {
				throw new UserDefinedException();
			}
		} catch (UserDefinedException u2) {
			System.out.println("This is not the output");
		} catch (Error e2) {
			System.out.println("This is the output");
		}
	}
}