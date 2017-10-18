public class NullObjectPatternDemo {
	public static void main(String[] args) {
		String[] drinkList = {"Cocacola", "Tea", "Dasani", "Juice", "Coke"};
		int bill = 0;
		System.out.println("Checking out items:");
		for (String drinkName : drinkList) {
			AbstractDrink drink = DrinkManager.getDrink(drinkName);
			System.out.println("- " + drinkName + ": " + (drink.isNull() ? drink.getName() : drink.getPrice() + "$."));
			bill += drink.getPrice();
		}
		
		System.out.println("Total bill: " + bill + "$.");
	}
}
