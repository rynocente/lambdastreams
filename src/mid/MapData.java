package mid;

import java.util.List;
import static mid.User.DEMO_DATA;

public class MapData {

	public static void main(String[] args) {
		
		
		//map to transform one collection intro another collection using a one-to-one function
		
		//v.0 map
		List<String> mapNames = DEMO_DATA.stream()
									.map(User::name)
									.toList();
		System.out.println(mapNames);
		//[Jhon, Sara, Michael, Sara, Dexter, Joey, Sheldon, Mike]

		//v.1 map return List<List<String>>
		var mapEmails_v1 = DEMO_DATA.stream()
								.map(User::emails)
								.toList();
		System.out.println(mapEmails_v1);
		//[[], [sara@gmail.com, sconnor@gmail.com], [mscott@theoffice.com], [sara.lee@hotmail.com], [dmorgan@gmail.com, dex@hotmail.com], [joeyt@gmail.com], ...
		
		
		
		//flatMap to transform one collection intro another collection using a one-to-many function
		
		//v.2 flatMap return List<String>
		List<String> mapEmails_v2 = DEMO_DATA.stream()
				.flatMap(user -> user.emails().stream())
				.toList();
		System.out.println(mapEmails_v2);	
		//[sara@gmail.com, sconnor@gmail.com, mscott@theoffice.com, sara.lee@hotmail.com, dmorgan@gmail.com, dex@hotmail.com, joeyt@gmail.com,..
		

	}

}
