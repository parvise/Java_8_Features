import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Pyramid {

	public static void main(String[] args) {

		int[] numbers = { 11, 22, 33, 44, 55, 66, 77, 88 };// { 1, 2, 3, 4, 5,
															// 6, 7, 8 };
		int[] doubleNumbers = new int[numbers.length];
		int[] tripleNumbers = new int[numbers.length];

		IntStream.range(0, numbers.length).forEach(index -> {
			doubleNumbers[index] = numbers[index] * 2;
			tripleNumbers[index] = numbers[index] * 3;
		});
		System.out.println(Arrays.toString(doubleNumbers) + ":" );
		System.out.println(Arrays.toString(doubleNumbers) + ":" + Arrays.toString(tripleNumbers));

		// Arrays.stream(numbers).map(Num::new).forEach((n) -> {
		// System.out.println("power of 2:" + n.powerOf(2));
		// });

		System.out.println();
		Stream<Integer> randomNumbers = Stream.generate(() -> new Random().nextInt(100));
		randomNumbers.limit(10).forEach((n -> {
			System.out.print(n + ",");
		}));

	}

}

class Num {
	int value;

	Num() {
	}

	public double powerOf(int index) {
		return Math.pow(value, index);
	}
}
