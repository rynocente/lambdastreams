package intro;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class JoinElements {

	public static void main(String[] args) {
		
		final List<String> friends = Arrays.asList("Joey","Chandler","Monica","Rachel","Ross","Phoebe");
		
		System.out.println(String.join(", ", friends));
		
		String joinNames = friends.stream()
									.map(name -> name.toUpperCase())
									.collect(Collectors.joining(", "));
		System.out.println(joinNames);
		
		
		
		

	}

}
