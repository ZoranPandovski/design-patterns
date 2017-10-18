public class RealDrink extends AbstractDrink {
	public RealDrink(String name, int price) {
		this.name = name;
		this.price = price;
	}
	
	@Override
	public String getName() {
		return name;
	}
	
	@Override
	public int getPrice() {
		return price;
	}
	
	@Override
	public boolean isNull() {
		return false;
	}
}