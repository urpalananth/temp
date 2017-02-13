package inst.an.java8;

import java.util.Arrays;
import java.util.List;

public class StreamsMap {
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(9, 5, 92, 78, 89, 3, 45);
		
		//old way to find total
		int total = 0;
		for (Integer integer : intList) {
			total += integer;
		}
		System.out.println(total);
		
		//Streams way of finding total
		System.out.println(intList.stream()
								  .map(e -> e *2)
								  .reduce(0, (c, e) -> c + e));
	}
}
