package mid;

import java.util.List;

public record User(String name, String lastName, List<String> emails) {

	public static final List<User> DEMO_DATA = List.of(
			new User("Jhon", "Doe", List.of()), 
			new User("Sara", "Connor", List.of("sara@gmail.com","sconnor@gmail.com")),
			new User("Michael", "Scott", List.of("mscott@theoffice.com")),
			new User("Sara", "Lee", List.of("sara.lee@hotmail.com","saralee@devs.pe")),
			new User("Dexter", "Morgan", List.of("dmorgan@gmail.com","dex@hotmail.com")),
			new User("Joey", "Tribbiani", List.of("joeyt@gmail.com")),
			new User("Sheldon", "Cooper", List.of("sheldonc@hotmail.com","scooper@gmail.com","sheldon.cooper@yahoo.com")),
			new User("Mike", "Ross", List.of("mikeross@gmail.com"))
			);
	
	
	public String fullName() {
		return name + " " + lastName;
	}
	
}
