package intro;

import java.util.Arrays;
import java.util.List;

public class Demo {

	public static void main(String[] args) {
		
		List<Integer> prices = Arrays.asList(30, 10, 21, 45, 1);
		
		final double totalDiscount = prices.stream()
										.filter(price -> price > 20)
										.mapToDouble(price -> price * 0.10)
										.sum();
		
		System.out.println("Total discount: " + totalDiscount);
		
		
		

	}

}
