package intro;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CompareElements {

	public static void main(String[] args) {
		
		List<Friend> friends = Arrays.asList(
				new Friend("Joey", 27),
				new Friend("Ross", 28),
				new Friend("Chandler", 28),
				new Friend("Rachel", 26),
				new Friend("Phoebe", 29),
				new Friend("Monica", 30));
		
		
		//v.1 sort by age asc
		 friends.stream()
			.sorted((f1, f2) -> f1.compareByAge(f2))
			.collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("---");
		
		
		//v.2 sort by age asc w method reference
		friends.stream()
		.sorted(Friend::compareByAge)
		.collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("---");
		
		
		//v.3 sort by age desc
		Comparator<Friend> c = (a, b) -> a.compareByAge(b); 
		
		friends.stream()
		.sorted(c.reversed())
		.collect(Collectors.toList()).forEach(System.out::println);
		
		System.out.println("---");
		
		
		//v.4 sort by name
		friends.stream()
		.sorted((f1, f2) -> f1.getName().compareTo(f2.getName()))
		.collect(Collectors.toList()).forEach(System.out::println);
		
		
		//v.5 multiple comparisons
		Function<Friend, Integer> byAge = friend -> friend.getAge();
		Function<Friend, String> byName = friend -> friend.getName();
		List<Friend> lst = friends.stream()
				.sorted(Comparator.comparing(byAge).thenComparing(byName))
				.collect(Collectors.toList());
		System.out.println(lst);
		
		
		

	}

}


class Friend {
	
	private String name;
	private int age;
	
	public Friend(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
	
	public int compareByAge(Friend friend) {
		return this.age - friend.age;
	}

	@Override
	public String toString() {
		return "[name=" + name + ", age=" + age + "]";
	}
	
	
	
}
