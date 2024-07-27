package mid;

import static mid.User.DEMO_DATA;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Grouping {

	public static void main(String[] args) {
		
		//iterate just one using partitioningBy(). The result of collect is a Map with two keys, true and false
		
		Map<Boolean, List<User>> groupUsers = DEMO_DATA.stream()
													.collect(Collectors.groupingBy(u -> u.emails().size() > 1));
		
		System.out.println("Users with multiple email: " + groupUsers.get(true).size());
		System.out.println("Users with at most one email: " + groupUsers.get(false).size());
		
		
		
		//grouping by name
		Map<String, Long> lstUsers = DEMO_DATA.stream()
										.collect(Collectors.groupingBy(User::name, Collectors.counting()));
		System.out.println(lstUsers);
		
		
		//change the type of result
		Map<String, Integer> lstUsersInt = DEMO_DATA.stream()
										.collect(Collectors.groupingBy(User::name, Collectors.collectingAndThen(Collectors.counting(), Long::intValue) ));
		System.out.println(lstUsersInt);
		
		
		//grouping by email
		Map<String, Integer> lstUsersByEmail = DEMO_DATA.stream()
										.collect(Collectors.groupingBy(User::fullName, Collectors.summingInt(u -> u.emails().size())));
		System.out.println(lstUsersByEmail);
		
		
		//grouping by fullName and emails
		Map<String, List<String>> lstUsersEmails = DEMO_DATA.stream()
			 .collect(Collectors.groupingBy(User::fullName, Collectors.flatMapping(u->u.emails().stream(), Collectors.toList())));
		System.out.println(lstUsersEmails);
		
		
		//filtering
		var lstUsersEmailsFilter = DEMO_DATA.stream()
				 .collect(Collectors.groupingBy(User::fullName,
						 Collectors.flatMapping(u->u.emails().stream(),
								 Collectors.filtering(e -> e.endsWith(".pe"), Collectors.toList())
								 )));
			System.out.println(lstUsersEmailsFilter);
			//{Jhon Doe=[], Sara Connor=[], Sara Lee=[saralee@devs.pe], Joey Tribbiani=[], Dexter Morgan=[], Michael Scott=[], Mike Ross=[], Sheldon Cooper=[]}

			
		//user who has the least number of email and most number of email
		var leastAndMost = DEMO_DATA.stream()
							.collect(
									Collectors.teeing(
											Collectors.minBy(Comparator.comparing(u->u.emails().size())),
											Collectors.maxBy(Comparator.comparing(u->u.emails().size())),
											(min, max) -> new MinMax(min.map(User::fullName).orElse(""), 
																	max.map(User::fullName).orElse("")))
									);
			System.out.println(leastAndMost);
			//MinMax[least=Jhon Doe, most=Sheldon Cooper]
			
	}

}

record MinMax(String least, String most) {
	
}



