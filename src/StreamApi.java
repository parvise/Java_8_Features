import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamApi {

	public static void main(String[] args) {

		List<String> strings = Arrays.asList("B", "", "A", " ", "X", "Q", "P", "A", "");
		System.out.println(strings + ":" + strings.size());

		// Remove Empty Spaces from List
		List<String> avl = strings.stream().filter(string -> !string.trim().isEmpty()).distinct()
				.collect(Collectors.toList());
		// Find Unique Elements & Sorting
		List<String> avl1 = strings.stream().filter(string -> !string.trim().isEmpty()).sorted()
				.map(string -> string.toLowerCase()).distinct().collect(Collectors.toList());
		System.out.println(avl + ":" + avl.size());
		System.out.println(avl1 + ":" + avl1.size());

		// Combine String Or Merge String
		String mergedString = strings.stream().filter(string -> !string.trim().isEmpty())
				.collect(Collectors.joining("|"));// .filter(string
		// ->
		// !string.isEmpty()).collect(Collectors.joining(""));
		System.out.println("Merged String: " + mergedString + ":" + mergedString.length());

		// Find Max,Min,Sum,Avg,count
		List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);

		System.out.println(numbers);
		
		numbers.stream().mapToLong((x) -> x*3).forEach(x -> {
			System.out.print(x + ",");
		});
		System.out.println();
		IntSummaryStatistics stats = numbers.stream().mapToInt((x) -> x*3).summaryStatistics();

		System.out.println(stats.getMax()+":"+stats.getSum()+":"+stats.getCount());
		
		List<String> namesList=new ArrayList<String>();
		namesList.add("Gujurat");
		namesList.add("Chandigarh");
		namesList.add("Doha");
		namesList.add("Haryana");
		namesList.add("Pune");
		namesList.add("Bangalore");
		namesList.add("Chennai");
		namesList.add("Delhi");
		
		List<String> namesList1 = namesList.stream().filter(s-> s.startsWith("C")).collect(Collectors.toList());
		System.out.println(namesList.stream().filter(s-> s.startsWith("C")).count());
		System.out.println(namesList1);
	}

}
