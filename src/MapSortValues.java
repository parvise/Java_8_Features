import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

public class MapSortValues {

	public static void main(String[] args) {
		
		String s1=new String("helllo");
		s1.intern();

		Map<Employee1, String> map = new LinkedHashMap<Employee1, String>();
		
		//Stream.of(new Employee1(1, "Pervez", 34, "Yes", 1000, 2017, "CSE")).col

		Employee1 e1 = new Employee1(1, "Pervez", 34, "Yes", 1000, 2017, "CSE");
		Employee1 e2 = new Employee1(3, "Abdul", 32, "Yes", 3000, 2018, "ECE");
		Employee1 e3 = new Employee1(2, "Kiran", 35, "Yes", 5000, 2015, "EEE");
		Employee1 e4 = new Employee1(4, "Prasad", 36, "Yes", 6000, 2012, "IT");
		Employee1 e5 = new Employee1(5, "Vishnu", 10, "Yes", 10000, 2017, "CSE");
		Employee1 e6 = new Employee1(6, "Lipin", 34, "Yes", 22000, 2017, "CSE");
		Employee1 e7 = new Employee1(7, "Siddu", 34, "No", 21000, 2017, "ECE");
		Employee1 e8 = new Employee1(8, "Ajase", 30, "No", 2000, 2017, "CIVIL");
		Employee1 e9 = new Employee1(9, "Hema", 38, "No", 2000, 2010, "CSE");
		Employee1 e10 = new Employee1(10, "Dilip", 34, "No", 1000, 2017, "CIVIL");
		Employee1 e11 = new Employee1(11, "Kamal", 34, "No", 2000, 2017, "CIVIL");
		Employee1 e12 = new Employee1(12, "Hari", 35, "Yes", 5000, 2015, "EEE");

		map.put(e1, "Pervez");
		map.put(e2, "Abdul");
		map.put(e3, "Kiran");
		map.put(e4, "Prasad");

		map.put(e5, "Vishnu");
		map.put(e6, "Lipin");
		map.put(e7, "Siddu");
		map.put(e8, "Ajase");

		map.put(e9, "Hema");
		map.put(e10, "Dilip");
		map.put(e11, "Kamal");
		map.put(e12, "Hari");

		System.out.println(map);

		List<Entry<Employee1, String>> entryList = new ArrayList<Entry<Employee1, String>>(map.entrySet());

		Collections.sort(entryList, new Comparator<Map.Entry<Employee1, String>>() {

			public int compare(Map.Entry<Employee1, String> o1, Map.Entry<Employee1, String> o2) {
				return (o1.getValue()).compareTo(o2.getValue());
			}
		});

		// Sort the list using lambda expression
		Collections.sort(entryList, (i1, i2) -> i1.getValue().compareTo(i2.getValue()));

		System.out.println(entryList);

		Map<Employee1, String> temp = map.entrySet().stream()
				.sorted((i1, i2) -> i2.getValue().compareTo(i1.getValue()))
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (l1, l2) -> l1, LinkedHashMap::new));
		
		Map<Employee1, String> temp1 = map.entrySet().stream()
				.sorted((i1, i2) -> i2.getKey().getAge().compareTo(i1.getKey().getAge()))// ? 1 :-1)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (l1, l2) -> l1, LinkedHashMap::new));

		System.out.println(temp);
		System.out.println(temp1);

	}

}
