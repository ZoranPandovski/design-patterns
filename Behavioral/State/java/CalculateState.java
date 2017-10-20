public class CalculateState implements CashierState{
	@Override
	public void cashierAction(StateContext stateContext) {
		// TODO Auto-generated method stub
		System.out.println("Cashier is calculating your bill");
		stateContext.setState(this);
	}
	
    public String toString() {
        return "CollectMoneyState";
    }
}
