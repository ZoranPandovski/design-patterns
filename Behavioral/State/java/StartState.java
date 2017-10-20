
public class StartState implements CashierState{
	@Override
	public void cashierAction(StateContext stateContext) {
		System.out.println("Cashier is starting with your shopping cart");
		stateContext.setState(this);
	}

	public String toString() {
        return "StartState";
    }
}