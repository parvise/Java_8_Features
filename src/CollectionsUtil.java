import java.util.ArrayList;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class CollectionsUtil {

	public static void main(String[] args) {

		List<Employee1> list = new ArrayList<Employee1>();
		createEmpList(list);

		for (Employee1 employee1 : list) {
			System.out.println("Actual Data :" + employee1);
		}

		// Print Max/Min Salray of Employees
		Optional<Employee1> highestSalary = list.stream()
				.collect(Collectors.maxBy(Comparator.comparingDouble(Employee1::getSalary)));

		Optional<Employee1> lowestSalary = list.stream()
				.collect(Collectors.minBy(Comparator.comparingDouble(Employee1::getSalary)));

		Optional<Double> lowestSalary1 = list.stream()
				.collect(Collectors.minBy(Comparator.comparingDouble(Employee1::getSalary))).map(emp -> emp.getSalary())
				.filter(emp -> emp == 1000);
		List<Employee1> diffList = list.stream().filter(emp -> emp.getSalary() == lowestSalary1.get())
				.collect(Collectors.toList());

		System.out.println("Highest : " + highestSalary);
		System.out.println("Lowest : " + lowestSalary);
		System.out.println("Lowest : " + lowestSalary1);
		System.out.println("diffList : " + diffList);

		// list.stream().collect(Comparator.comparingDouble(Employee1::getSalary));

		// Find the lowest salary of List of Employees
		diffList = list.stream()
				.filter(emp -> emp.getSalary() == list.stream()
						.collect(Collectors.minBy(Comparator.comparingDouble(Employee1::getSalary))).get().getSalary())
				.collect(Collectors.toList());
		System.out.println("diffList : " + diffList);

		// Print Max salary from each Department
		System.out.println("******** Max Sal from Each Dept ************");

		Map<String, Optional<Employee1>> map = list.stream().collect(Collectors.groupingBy(Employee1::getDepartment,
				Collectors.maxBy(Comparator.comparing(Employee1::getSalary))));

		Map<String, Optional<Employee1>> map1 = list.stream().collect(Collectors.groupingBy(Employee1::getDepartment,
				Collectors.reducing(BinaryOperator.maxBy(Comparator.comparingDouble(Employee1::getSalary)))));

		// list.stream().map(Employee1::getSalary).forEach((emp) ->
		// System.out.print(emp+","));

		map.forEach((key, value) -> System.out.println(key + ":" + value));
		System.out.println("********Max Sal from Each Dept***********");
		map1.forEach((key, value) -> System.out.println(key + ":" + value));
		System.out.println(":::: Max Sal from Each Dept List {{{{{{{{{{{{{{{{{{{{[");

		List<Employee1> maxSalEachDeptMulList = list.stream()
				.filter(emp1 -> map1.containsKey(emp1.getDepartment())
						&& map1.get(emp1.getDepartment()).get().getSalary() == emp1.getSalary())
				.collect(Collectors.toList());
		for (Employee1 employee1 : maxSalEachDeptMulList) {
			System.out.println("maxSalEachDeptMulList..." + employee1);
		}

		// Program To Print ACtive/Inactive Employees or Male/Female
		Map<String, Long> activeInact = list.stream() // filter(e->e.getDepartment()==cse)
				.collect(Collectors.groupingBy(Employee1::getActive, Collectors.counting()));
		System.out.println("********* ACtive/Inactive Employees **********");
		activeInact.forEach((key, value) -> System.out.println(key + ":" + value));

		System.out.println("********Unique Deptartments***********");
		// Program To print Unique Deptartments
		Map<String, List<Employee1>> emp = list.stream().collect(Collectors.groupingBy(Employee1::getDepartment));
		list.stream().map(Employee1::getDepartment).distinct().forEach((dept) -> System.out.print(dept + ","));
		System.out.println(emp);
		Map<String, Long> empt = list.stream()
				.collect(Collectors.groupingBy(Employee1::getDepartment, Collectors.counting()));
		System.out.println(empt);
		// Average age of Active/Inactive ages
		Map<String, Double> avgAge = list.stream()
				.collect(Collectors.groupingBy(Employee1::getActive, Collectors.averagingInt(Employee1::getAge)));
		System.out.println("******Average age of Active/Inactive ages******");
		System.out.println(avgAge);

		System.out.println("****** Employees DOJ > 2015******");
		// Get the Employees DOJ > 2015
		List<String> filter = list.stream().filter(emp1 -> emp1.getYearOfJoin() > 2015).map(Employee1::getEmpName)
				.collect(Collectors.toList());

		System.out.println(filter);

		// Youngest employee of active from CSE department
		System.out.println("*****Youngest employee of active from CSE department*******");
		Optional<Employee1> younge = list.stream()
				.filter(e -> e.getActive().equalsIgnoreCase("YES") && e.getDepartment().equalsIgnoreCase("CSE"))
				.min(Comparator.comparingInt(Employee1::getAge));
		System.out.println(younge.get());

		System.out.println("*****Most experience employee of the organization*******");
		// Find the Most experience employee of the organization
		Optional<Employee1> mostExp = list.stream().sorted(Comparator.comparingInt(Employee1::getYearOfJoin))
				.findFirst();
		System.out.println(mostExp.get());

		System.out.println("******avg & Total salary of the oRganization******");
		// Find the avg & Total salary of the oRganization
		DoubleSummaryStatistics ds = list.stream().collect(Collectors.summarizingDouble(Employee1::getSalary));

		System.out.println(ds.getMax() + ":" + ds.getMin() + ":" + ds.getSum());

		System.out.println("*****who are younger or equal to 34 and who are old age*******");
		// Find the employees who are younger or equal to 34 and who are old age
		// employees
		Map<Boolean, List<Employee1>> young = list.stream().collect(Collectors.partitioningBy(e -> e.getAge() > 34));

		for (Boolean string : young.keySet()) {
			List<Employee1> emp1 = young.get(string);
			System.out.println("********" + string);
			for (Employee1 employee1 : emp1) {
				System.out.println(employee1.getEmpName());
			}

		}
	}

	private static void createEmpList(List<Employee1> list) {

		list.add(new Employee1(1, "Pervez", 34, "Yes", 1000, 2017, "CSE"));
		list.add(new Employee1(3, "Abdul", 32, "Yes", 3000, 2018, "ECE"));
		list.add(new Employee1(2, "Kiran", 35, "Yes", 5000, 2015, "EEE"));
		list.add(new Employee1(4, "Prasad", 36, "Yes", 6000, 2012, "IT"));
		list.add(new Employee1(5, "Vishnu", 10, "Yes", 10000, 2017, "CSE"));
		list.add(new Employee1(6, "Lipin", 34, "Yes", 22000, 2017, "CSE"));
		list.add(new Employee1(7, "Siddu", 34, "No", 21000, 2017, "ECE"));
		list.add(new Employee1(8, "Ajase", 30, "No", 2000, 2017, "CIVIL"));
		list.add(new Employee1(9, "Hema", 38, "No", 2000, 2010, "CSE"));
		list.add(new Employee1(10, "Dilip", 34, "No", 1000, 2017, "CIVIL"));
		list.add(new Employee1(11, "Kamal", 34, "No", 2000, 2017, "CIVIL"));
		list.add(new Employee1(12, "Hari", 35, "Yes", 5000, 2015, "EEE"));
	}
	

}

class Employee1 {
	private long id;
	private String empName;
	private Integer age;
	private String active;
	private double salary;
	private int yearOfJoin;
	private String department;

	public Employee1(long id, String empName, Integer age, String active, double salary, int yearOfJoin,
			String department) {
		super();
		this.id = id;
		this.empName = empName;
		this.age = age;
		this.active = active;
		this.salary = salary;
		this.yearOfJoin = yearOfJoin;
		this.department = department;
	}

	public long getId() {
		return id;
	}

	public String getEmpName() {
		return empName;
	}

	public Integer getAge() {
		return age;
	}

	public String getActive() {
		return active;
	}

	public double getSalary() {
		return salary;
	}

	public int getYearOfJoin() {
		return yearOfJoin;
	}

	public String getDepartment() {
		return department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", age=" + age + ", active=" + active + ", salary="
				+ salary + ", yearOfJoin=" + yearOfJoin + ", department=" + department + "]";
	}

}
