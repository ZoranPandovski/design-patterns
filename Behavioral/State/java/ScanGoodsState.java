
public class ScanGoodsState implements CashierState{
	@Override
	public void cashierAction(StateContext stateContext) {
		System.out.println("Cashier is scanning your goods");
		stateContext.setState(this);
	}
	
    public String toString() {
        return "ScanGoodsState";
    }
}
