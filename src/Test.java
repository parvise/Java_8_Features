public class Test {

	public static void main(String[] args) {
		A a = new A();
		a.add();
		
		String s = "geeksforgeeks";
        String subString = s.substring(4,6);
        System.out.print(subString);
	}

}

class A {
	// A a = new A();

	public void add() {
		System.out.println("Hi");
	}
}