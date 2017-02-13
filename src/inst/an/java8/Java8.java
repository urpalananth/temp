package inst.an.java8;

import java.util.Arrays;

public class Java8 {
	public static void main(String[] args) {
		Arrays.asList("Ananth, Meenal, Shravani, Yashoda".split(", ")).forEach(System.out::println);
	}
}
