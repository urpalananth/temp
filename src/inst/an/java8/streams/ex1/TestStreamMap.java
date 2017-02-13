package inst.an.java8.streams.ex1;

import static java.util.stream.Collectors.toList;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TestStreamMap {

	public static void main(String[] args) {
		List<BigDecimal> doubles = Arrays.asList(new BigDecimal(1), new BigDecimal(2), new BigDecimal(3), new BigDecimal(4));
		List<Object> objs = doubles.stream()
			   .map(e -> (Object)e)
			   .collect(toList());
		
		List<Long> longList = 
			objs.stream()
				.map(e -> ((BigDecimal)e).longValue())
				.collect(toList());
		
		longList.stream()
				.forEach(System.out::print);
		
		List<Employee> empList = Stream.of(
				new Employee(1L, "Acc", 500D),
				new Employee(2L, "Acc", 1000D),
				new Employee(3L, "SW", 1000D),
				new Employee(4L, "SW", 1000D),
				new Employee(5L, "Acc", 1000D))
				.collect(Collectors.toList());
		
		 Map<String, List<Employee>> collector = empList.stream()
			   .filter(e -> e.getSalary() > 500)
			   .collect(Collectors.groupingBy(Employee::getDept));
		 
		 System.out.println(collector);
		 
		 Object[] objArray = {"ananth", "kumar"};
		 Object[] objArray1 = {"sanotsh", "kumar"};
		 Object[] objArray2 = {"vijay", "kumar"};
		 
		 List<Object[]> objArrayList = Stream.of(objArray, objArray1, objArray2)
		 		.collect(Collectors.toList());
		 
		 objArrayList.stream()
		 			 .map(e-> new FullName(e[1].toString(), e[0].toString()))
		 			 .forEach(System.out::println);
		 
		 
	}
}
