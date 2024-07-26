package mid;

import static mid.User.DEMO_DATA;

import java.util.List;
import java.util.stream.Collectors;

public class Average {

	public static void main(String[] args) {
		
		//average number of email addresses
		
		
		//v.1
		System.out.println("Average v1: "
				+ DEMO_DATA.stream()
				.map(User::emails)
				.mapToDouble(List::size)
				.sum()/DEMO_DATA.size() * 1.0);
		
		//v.2
		System.out.println("Average v2: "
				+ DEMO_DATA.stream()
				.map(User::emails)
				.mapToDouble(List::size)
				.average().orElse(0));
		
		//v.3
		System.out.println("Average v3: "
				+ DEMO_DATA.stream()
				.mapToDouble(u -> u.emails().size())
				.average().orElse(0));
		
		//v.4
		System.out.println("Average v4: "
				+ DEMO_DATA.stream()
				.collect(Collectors.averagingDouble(u -> u.emails().size())));
		
		
		System.out.println("--- statistics ---");
		
		var data = DEMO_DATA.stream()
							.collect(Collectors.summarizingDouble(u -> u.name().length()));
		
		System.out.println("Total users: " + data.getCount());
		System.out.println("Total emails: " + data.getSum());
		System.out.println("Average emails: " + data.getAverage());
		System.out.println("Max number of emails: " + data.getMax());
		System.out.println("Min number of emails: " + data.getMin());
		
		
		
		
		

	}

}
