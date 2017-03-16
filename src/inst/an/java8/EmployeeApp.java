package inst.an.java8;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeApp {

	public static void main(String[] args) {
		
		List<Employee> eList = Stream.of(new Employee(1L, "emp1", 3L, 9000D), 
				new Employee(2L, "emp2", 4L, 7000D), 
				new Employee(3L, "emp3", 4L, 5000D), 
				new Employee(4L, "emp4", 2L, 9900D), 
				new Employee(5L, "emp5", 1L, 5000D), 
				new Employee(6L, "emp6", 3L, 8000D), 
				new Employee(7L, "emp7", 1L, 1000D)).collect(Collectors.toList());
		
		Map<Long, Employee> deptMaxSalary = new HashMap<>();
		
		
		/**
		 * Finding max salary in each dept - traditional way
		 */
		for(Employee e : eList){
			if(deptMaxSalary.get(e.getDeptId()) == null){
				deptMaxSalary.put(e.getDeptId(), e);
			} else {
				if(e.getSalary() > deptMaxSalary.get(e.getDeptId()).getSalary()){
					deptMaxSalary.put(e.getDeptId(), e);
				}
			}
		}
		
		for (Map.Entry<Long, Employee> entry : deptMaxSalary.entrySet()) {
			System.out.println(entry.getKey() + " - " + entry.getValue());
		}
		
		/**
		 * Finding max salary in each dept - using streams and lambdas
		 */
		Comparator<Employee> bySalary = Comparator.comparing(Employee::getSalary);
		
		eList.stream().collect(
				Collectors.groupingBy(Employee::getDeptId, 
						Collectors.reducing(BinaryOperator.maxBy(bySalary)))).forEach((k, v)-> {
							System.out.println(k +" - "+v);
						});
	}
}
