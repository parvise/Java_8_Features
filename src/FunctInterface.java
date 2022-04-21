import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class FunctInterface {

	public static void main(String[] args) {

		String element = "Hellow World";
		String elements[] = { "B", "", "A", "", "X", "Q", "P", "A", "" };

		List<String> list = Arrays.asList(elements);
		System.out.println("Array:" + Arrays.toString(elements));
		System.out.println("List:" + list);

		System.out.println("Count" + elements.length + ":" + list.size());

		List<String> distinctElements = new ArrayList<String>();
		List<String> duplicateElements = new ArrayList<String>();
		int emptyCount = 1;
		for (String string : list) {
			if (!distinctElements.contains(string))
				distinctElements.add(string);
			else if (string.isEmpty()) {
				emptyCount++;
			} else
				duplicateElements.add(string);
		}
		System.out.println("Empty Count:" + emptyCount);
		System.out.println("Unique" + distinctElements);
		System.out.println("Dup" + duplicateElements);

		java.util.Collections.sort(distinctElements, new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				return o2.compareTo(o1);
			}
		});

		System.out.println("Ascending" + distinctElements);

	}

}
