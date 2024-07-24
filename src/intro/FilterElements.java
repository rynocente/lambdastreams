package intro;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class FilterElements {

	public static void main(String[] args) {
		
		final List<String> friends = Arrays.asList("Joey","Chandler","Monica","Rachel","Ross","Phoebe");
		
		//v.0 Filter out names that start with R
		final long countFriendsStartR = friends.stream()
												.filter(name -> name.startsWith("R"))
												.count();
		System.out.println(countFriendsStartR);
		
		System.out.println("---");
		
		
		//v.1 refactor v.0 create lambda expression
		Predicate<String> startsWithR = name -> name.startsWith("R");
		
		final long countFriendsStartR_v2 = friends.stream()
													.filter(startsWithR)
													.count();
		System.out.println(countFriendsStartR_v2);
		
		System.out.println("---");
		
		
		//v.2 Pick the names that start with P or M
		Predicate<String> startsWithP = name -> name.startsWith("P");//duplicate lambda
		Predicate<String> startsWithM = name -> name.startsWith("M");//duplicate lambda
		
		final long countFriendsStartP = friends.stream()
												.filter(startsWithP)
												.count();
		System.out.println(countFriendsStartP);
		
		final long countFriendsStartM = friends.stream()
												.filter(startsWithM)
												.count();
		System.out.println(countFriendsStartM);
		
		System.out.println("---");
		
		
		//v.3 refactor v.2 removing duplication with lexical scoping, call checkText
		final long countFriendsStartP_v2 = friends.stream()
													.filter(checkText("P"))
													.count();
		System.out.println(countFriendsStartP_v2);
		
		final long countFriendsStartM_v2 = friends.stream()
													.filter(checkText("M"))
													.count();
		System.out.println(countFriendsStartM_v2);
		
		System.out.println("---");
		
		
		//v.4 refactor v,3 to narrow the scope
		final Function<String, Predicate<String>> startsWithLetter = letter -> name -> name.startsWith(letter);
		final long countFriendsStartP_v3 = friends.stream()
													.filter(startsWithLetter.apply("P"))
													.count();
		System.out.println(countFriendsStartP_v3);
		
		final long countFriendsStartM_v3 = friends.stream()
													.filter(startsWithLetter.apply("M"))
													.count();
		System.out.println(countFriendsStartM_v3);
		
		

	}
	
	
	
	public static Predicate<String> checkText(final String text) {
		return name -> name.startsWith(text);
	}
	
	
	

}
