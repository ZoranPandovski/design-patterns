public class NullDrink extends AbstractDrink {
	@Override
	public String getName() {
		return "Drink not found.";
	}
	
	@Override
	public int getPrice() {
		return 0;
	}
	
	@Override
	public boolean isNull() {
		return true;
	}
}