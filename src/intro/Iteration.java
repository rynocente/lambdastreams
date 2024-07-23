package intro;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Iteration {

	public static void main(String[] args) {
		
		final List<String> friends = Arrays.asList("Joey","Chandler","Monica","Rachel","Ross","Phoebe");
		
		//v.0 verbose, don't do this
		friends.forEach(new Consumer<String>() {

			@Override
			public void accept(String arg0) {
				System.out.println(arg0);
			}
		});
		
		
		System.out.println("---");
		
		
		//v.1 java compiler can infer the types based on the context
		friends.forEach(name -> System.out.println(name));
		
		
		System.out.println("---");
		
		
		//v.2 method reference
		friends.forEach(System.out::println);
		
		
		
		System.out.println("---");
		
		
		//transforming list
		friends.stream()
				.map(String::toUpperCase)
				.forEach(System.out::println);
		
		

	}

}
