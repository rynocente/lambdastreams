package intro;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class CollectElements {

	public static void main(String[] args) {
		
		List<Friend> friends = Arrays.asList(
				new Friend("Joey", 27),
				new Friend("Ross", 28),
				new Friend("Chandler", 28),
				new Friend("Rachel", 26),
				new Friend("Phoebe", 29),
				new Friend("Monica", 30));
		
		
		//v.1 
		List<Friend> olders = new ArrayList<>(); 
		
		friends.stream()
				.filter(f -> f.getAge() > 27)
				.forEach(f -> olders.add(f)); //BAD IDEA
		System.out.println(olders);
		
		
		//v.2 refactor
		List<Friend> olders_v2 = friends.stream()
				.filter(f -> f.getAge() > 27)
				.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);
		System.out.println(olders_v2);
		
		
		//v.3
		List<Friend> olders_v3 = friends.stream()
				.filter(f -> f.getAge() > 27)
				.collect(Collectors.toList()); //toSet, toMap
		System.out.println(olders_v3);
		
		
		//groupingBy age
		Map<Integer, List<Friend>> olders_v4 = friends.stream()
				.filter(f -> f.getAge() > 27)
				.collect(Collectors.groupingBy(Friend::getAge)); 
		System.out.println("groupingBy" + olders_v4);
		
		System.out.println("---");
		
		//group by age
		Map<Integer, List<String>> lst2 = friends.stream()
												.collect(Collectors.groupingBy(
														Friend::getAge,
														Collectors.mapping(Friend::getName, Collectors.toList())));
		System.out.println(lst2);//{26=[Rachel], 27=[Joey], 28=[Ross, Chandler], 29=[Phoebe], 30=[Monica]}
		
		
		System.out.println("---");
		
		
		//group by name 1st char - oldest
		Comparator<Friend> comp = Comparator.comparing(Friend::getAge);
		Map<Character, Optional<Friend>> lst3 = friends.stream()
													.collect(Collectors.groupingBy(
															f -> f.getName().charAt(0),
															Collectors.reducing(
																	BinaryOperator.maxBy(comp)
																	)
															));
		System.out.println(lst3);
		//{P=Optional[[name=Phoebe, age=29]], R=Optional[[name=Ross, age=28]], C=Optional[[name=Chandler, age=28]], 
		//J=Optional[[name=Joey, age=27]], M=Optional[[name=Monica, age=30]]}

		
		

	}

}
