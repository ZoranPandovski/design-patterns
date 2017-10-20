
public class StatePatternDemo {
    public static void main(String[] args) {
        StateContext context = new StateContext();

        StartState startState = new StartState();
        startState.cashierAction(context);

        System.out.println(context.getState().toString());

        ScanGoodsState scanState = new ScanGoodsState();
        scanState.cashierAction(context);

        System.out.println(context.getState().toString());

        CalculateState calculateState = new CalculateState();
        calculateState.cashierAction(context);

        System.out.println(context.getState().toString());
        
        CollectMoneyState collectMoneyState = new CollectMoneyState();
        collectMoneyState.cashierAction(context);

        System.out.println(context.getState().toString());

        FinishState finishState = new FinishState();
        finishState.cashierAction(context);

        System.out.println(context.getState().toString());
    }
}
