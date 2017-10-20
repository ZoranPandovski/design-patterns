
public class FinishState implements CashierState{
	@Override
	public void cashierAction(StateContext stateContext) {
		System.out.println("Cashier is done with your shopping cart");
		stateContext.setState(this);
	}
    
    public String toString() {
        return "FinishState";
    }
}