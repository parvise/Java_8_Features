import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Predicate;

public class Lamda {

	public static void main(String[] args) {
		// Lambda Expressions are Functional Programming
		Predicate<Integer> p = a -> {
			return a ==5 ? true : false;
		};
		System.out.println(p.test(6));
		
		Interface g =()->{System.out.println("Hi");};
		g.say();
		MathOperation old=new MathOperation(){

			@Override
			public int operation(int a, int b) {
				return a+b;
			}
			
		};
		old.operation(5, 6);

		// with out type declaration without Curly braces
		MathOperation addition = (a, b) -> a + b;
		System.out.println(addition.operation(5, 10));

		// with type declaration without Curly braces
		MathOperation subraction = (int a, int b) -> a - b;
		System.out.println(subraction.operation(5, 10));

		BiConsumer<Integer, Integer> consume = (Integer a, Integer b) -> System.out.println(a + b);
		consume.accept(10, 30);

		// with return statement along with curly braces return is important
		MathOperation multiplication = (int a, int b) -> {
			System.out.println("Test");
			return a * b;
		};
		System.out.println(multiplication.operation(5, 10));

		List<String> list = new ArrayList<String>();

		// Method refernce is a replacement of lambda expression
		list.forEach(System.out::println);
		// list.forEach(Lamda::test);
	}

	static String test() {
		return "Test";
	}

}

// Lambda expressions are used primarily to define inline implementation of a
// functional interface, i.e., an interface with a atleast one single abstract
// method only &
// multiple default & static methods.
@FunctionalInterface
interface MathOperation {
	abstract int operation(int a, int b);

	default String sayMessage(String message) {
		return message;
	}
}

interface Interface{
	void say();
}
