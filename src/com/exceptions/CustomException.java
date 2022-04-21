package com.exceptions;

public class CustomException {

	public static void main(String[] args) {
		MinorAgeValidation obj = new MinorAgeValidation();

		try {
			System.out.println("Test..." + obj.getAgeValidation(19));
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (MinorAgeException e) {
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Throwable e) {
			e.printStackTrace();
		}
		
		obj.test();
		obj.test1();
		obj.add();
	}

}

@FunctionalInterface
interface Java8{
	default void test(){
		System.out.println("I am default");
	}
	
	default void test1(){
		System.out.println("I am default1");
	}
	 
	void add();
}

class MinorAgeException extends Exception {
	public MinorAgeException(String message) {
		super(message);
	}
}

class MinorAgeValidation implements Java8 {
	public String getAgeValidation(int age) throws MinorAgeException {
		if (age > 18) {
			return "Major";
		} else {
			throw new MinorAgeException(String.format("The give Age is Minor[%d]", age));
		}
	}

	@Override
	public void add() {
		System.out.println("I am add..");
	}
}
