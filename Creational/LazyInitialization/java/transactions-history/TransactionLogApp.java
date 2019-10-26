import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TransactionLogApp {

    static class TransactionLogsDAODummyImpl implements TransactionLogsDAO {

        @Override
        public Collection<TransactionLog> getHistory(Long clientId, int month, int year) {
            List<TransactionLog> result = new ArrayList<>();
            if(month == 5) {
                result.add(new TransactionLog(clientId, "12345", "54321", LocalDateTime.of(year, month, 4, 12, 12, 12), BigDecimal.TEN));
                result.add(new TransactionLog(clientId, "12345", "2322323", LocalDateTime.of(year, month, 3, 10, 12, 12), BigDecimal.TEN));
                result.add(new TransactionLog(clientId, "12345", "11111111", LocalDateTime.of(year, month, 2, 13, 12, 12), BigDecimal.TEN));
            } else if( month == 1) {
                result.add(new TransactionLog(clientId, "12345", "9999999", LocalDateTime.of(year, month, 29, 12, 12, 12), BigDecimal.valueOf(1212.44)));
                result.add(new TransactionLog(clientId, "12345", "9999999", LocalDateTime.of(year, month, 25, 10, 10, 10), BigDecimal.valueOf(1212.44)));

            }
            System.out.println(String.format("history called for month: %s, year: %s", month, year));
            return result;
        }
    }

    private static Iterator<TransactionLog> getTransactionLogs(long clientId) {
        TransactionLogsDAO transactionLogsDAO = new TransactionLogsDAODummyImpl();
        return new CurrentYearLazyLoadingTransactionLogsIterator(transactionLogsDAO, clientId);
    }

    public static void main(String[] args) {

        long clientId = 123;
        Iterator<TransactionLog> transactionLogsIterator = getTransactionLogs(clientId);

        while(transactionLogsIterator.hasNext()){
            TransactionLog transactionLog = transactionLogsIterator.next();
            System.out.println(transactionLog);
        }
    }
}
