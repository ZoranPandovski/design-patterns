import java.time.LocalDate;
import java.util.*;


public class CurrentYearLazyLoadingTransactionLogsIterator implements Iterator<TransactionLog> {

    private long clientId;
    private TransactionLogsDAO transactionLogsDAO;

    private int currentMonth;
    private int currentYear;
    private Iterator<TransactionLog> currentMonthHistoryIterator;

    public CurrentYearLazyLoadingTransactionLogsIterator(TransactionLogsDAO transactionLogsDAO, long clientId) {
        this.transactionLogsDAO = transactionLogsDAO;
        this.clientId = clientId;

        LocalDate today = LocalDate.now();
        this.currentMonth = today.getMonthValue();
        this.currentYear = today.getYear();
        loadDateForCurrentDate();
    }

    private void loadDateForCurrentDate() {
        Collection<TransactionLog> history = transactionLogsDAO.getHistory(clientId, currentMonth, currentYear);
        currentMonthHistoryIterator = history.iterator();
    }


    @Override
    public boolean hasNext() {
        if(!currentMonthHistoryIterator.hasNext()) {
            currentMonth--;
            if(currentMonth <= 0){
                return false;
            }
            loadDateForCurrentDate();
            if(!currentMonthHistoryIterator.hasNext()) {
                return hasNext();
            }
        }
        return true;
    }

    @Override
    public TransactionLog next() {
        return currentMonthHistoryIterator.next();
    }
}
