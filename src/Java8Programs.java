import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Java8Programs {

	public static void main(String[] args) {

		// Find Duplicate Numbers from Array without iteration or for loop
		List<Integer> numbers = Arrays.asList(11,10, 3, 2, 1,2, 5, 3, 7, 3, 5, 10);
		Set<Integer> set = new HashSet<Integer>();
		numbers.stream().filter(x -> set.add(x)).collect(Collectors.toSet())
		.forEach(x -> System.out.print(x + ","));
		System.out.println(set);
		System.out.println("==========================");
		// Multipkly two numbers using Functional Inteface
		FiMultiply mul = (a, b) -> {
			return a * b;
		};
		System.out.println("Mull : " + mul.multiply(10, 2));
		System.out.println("==========================");

		System.out.println("limit");
		// Limit & skip are intermediate functions
		numbers.stream().limit(0).forEach(x -> System.out.print(x + ","));
		System.out.println("limit");
		numbers.stream().skip(0).forEach(x -> System.out.print(x + ","));
		System.out.println("skip");
		System.out.println("==========================");

		// Count the no. of word occurences in given string
		String countNumber = "welcome to spring boot and spring boot welcome you";

		List<String> list = Arrays.asList(countNumber.split(" "));

		System.out.println("IMP");
		Map<String, Long> map = list.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println("Map;" + map);
	}

}

@FunctionalInterface
interface FiMultiply {
	int multiply(int a, int b);
}