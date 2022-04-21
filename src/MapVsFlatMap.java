import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class MapVsFlatMap {

	public static void main(String[] args) {

		List<Employee> employeeList = new ArrayList<Employee>();

		List<String> places = new ArrayList<String>();
		places.add("Pune");
		places.add("Bangalore");
		places.add("Chennai");
		places.add("Delhi");

		employeeList.add(new Employee(1, "Pervez", places));

		List<String> places1 = new ArrayList<String>();
		places1.add("Kerala");
		places1.add("Bangalore");
		places1.add("Delhi");

		employeeList.add(new Employee(2, "Kiran", places1));

		List<String> places2 = new ArrayList<String>();
		places2.add("Bangalore");
		places2.add("Chennai");

		employeeList.add(new Employee(3, "Prasad", places2));

		System.out.println("-------");
		employeeList.stream().filter(emp -> emp.getName().startsWith("P")).forEach(System.out::println);

		List<List<String>> placesList = employeeList.stream().map(emp -> emp.getPlaces()).collect(Collectors.toList());
		System.out.println("***");
		System.out.println(placesList);

		Set<List<String>> set = employeeList.stream().map(emp -> emp.getPlaces()).collect(Collectors.toSet());

		System.out.println("MAP" + set);

		Set<String> set1 = employeeList.stream().flatMap(emp -> emp.getPlaces().stream()).collect(Collectors.toSet());

		System.out.println("FLAT_MAP" + set1);
	}

}

class Employee {
	int id;
	String name;
	List<String> places = new ArrayList<String>();

	public Employee(int id, String name, List<String> places) {
		super();
		this.id = id;
		this.name = name;
		this.places = places;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<String> getPlaces() {
		return places;
	}

	public void setPlaces(List<String> places) {
		this.places = places;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", places=" + places + "]";
	}

}
