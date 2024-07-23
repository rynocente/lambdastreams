package intro;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class PickElements {

	public static void main(String[] args) {
		
		final List<String> friends = Arrays.asList("Joey","Chandler","Monica","Rachel","Ross","Phoebe");
		
		pick(friends, "x");
		
		getLongest(friends);
		
	}
	
	//optional
	private static void pick(List<String> names, String start) {
		
		Optional<String> found = names.stream()
				.filter(name -> name.startsWith(start))
				.findFirst();
		
		System.out.println(String.format("Name with %s: %s", start, found.orElse("No found")));
		
		
		
	}
	
	//reduce
	private static void getLongest(List<String> names) {
		
		Optional<String> opt = names.stream()
									.reduce((name1, name2) -> name1.length() > name2.length() ? name1 : name2);
		opt.ifPresent(name -> System.out.println(String.format("Longest name: %s", name)));
		
	}
	
	

}
