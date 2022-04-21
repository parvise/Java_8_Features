import java.util.stream.IntStream;

public class StreamVsParallelStream {

	public static void main(String[] args) {

		long start = 0;
		long end = 0;
		start = System.currentTimeMillis();
		
		IntStream.range(1, 10).forEach(x -> {
			System.out.print(x + ",");
			System.out.println("Thread Normal : " + Thread.currentThread().getName());
		});
		end = System.currentTimeMillis();
		System.out.println();
		System.out.println("Normal Stream :" + (end - start));
		System.out.println("***********************");

		start = System.currentTimeMillis();
		IntStream.range(1, 10).parallel().forEach(x -> {
			System.out.print(x + ",");
			System.out.println("Thread Parallel : " + Thread.currentThread().getName());
		});
		end = System.currentTimeMillis();
		System.out.println();
		System.out.println("Parallel Stream :" + (end - start));
		System.out.println("***********************");

	}

}
