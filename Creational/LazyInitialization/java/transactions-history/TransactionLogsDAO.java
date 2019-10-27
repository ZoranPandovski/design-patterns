import java.util.Collection;

public interface TransactionLogsDAO {

    Collection<TransactionLog> getHistory(Long clientId, int month, int year);
}
