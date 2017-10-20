
public class CollectMoneyState implements CashierState{
    @Override
	public void cashierAction(StateContext stateContext) {
		System.out.println("Cashier is collecting your money");
		stateContext.setState(this);
	}
    
    public String toString() {
        return "CollectMoneyState";
    }
}
