
public class StateContext {
    private CashierState cashierstate;

    public StateContext(){
    	cashierstate = null;
    }

    public void setState(CashierState cashierstate){
        this.cashierstate = cashierstate;		
    }

    public CashierState getState(){
        return cashierstate;
    }
}
