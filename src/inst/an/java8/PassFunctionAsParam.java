package inst.an.java8;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PassFunctionAsParam {
	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(0, 2, 9, 5, 78, 72, 3, 64);
		
		System.out.println(totalValues(intList, e -> true));
		System.out.println(totalValues(intList, e -> e % 2 == 0));
		System.out.println(totalValues(intList, e -> e % 2 != 0));
	}

	private static Integer totalValues(List<Integer> intList, Predicate<Integer> selector) {
		return intList.stream()
			   .filter(selector)
			   .reduce(0, (e, c) -> c + e);
		
	}
}
