
public class PizzaStore {
	
	public void orderPizza(String type) {
		Pizza pizza = SimplePizzaFactory.createPizza(type);
		pizza.prepare();
		pizza.bake();
		pizza.cut();
		pizza.box();
		
	}
}
