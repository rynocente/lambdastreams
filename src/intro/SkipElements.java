package intro;

import java.util.Arrays;
import java.util.List;

public class SkipElements {

	public static void main(String[] args) {
		
		final List<String> friends = Arrays.asList("Joey","Chandler","Monica","Rachel","Ross","Phoebe");
		
		friends.stream()
				.skip(4)
				.map(String::toUpperCase)
				.forEach(System.out::println);
		
		
		System.out.println("---");
		
		//delete while true. JDK9
		friends.stream()
				.dropWhile(name -> name.length() > 4)
				.map(String::toUpperCase)
				.forEach(System.out::println);
		
		
		//exit an iteration before reaching the end of a collection: limit() and takeWhile(), JDK9 
		
		

	}

}
