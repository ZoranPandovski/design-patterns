import java.util.HashMap;
import java.util.Map;

public class DrinkManager {
	public static final Map<String, Integer> data = new HashMap<String, Integer>(){{
		put("Coke", 10);
		put("Tea", 5);
		put("Coffee", 3);
	}};
	
	public static AbstractDrink getDrink(String drinkName){
		return data.containsKey(drinkName) ? new RealDrink(drinkName, data.get(drinkName)) : new NullDrink();
	}
}