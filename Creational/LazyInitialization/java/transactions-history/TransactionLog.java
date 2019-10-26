import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionLog {
    private long clientId;
    private String senderAccountNumber;
    private String receiverAccountNumber;
    private LocalDateTime date;
    private BigDecimal amount;

    public TransactionLog(long clientId, String senderAccountNumber, String receiverAccountNumber, LocalDateTime date, BigDecimal amount) {
        this.clientId = clientId;
        this.senderAccountNumber = senderAccountNumber;
        this.receiverAccountNumber = receiverAccountNumber;
        this.date = date;
        this.amount = amount;
    }

    public long getClientId() {
        return clientId;
    }

    public String getSenderAccountNumber() {
        return senderAccountNumber;
    }

    public String getReceiverAccountNumber() {
        return receiverAccountNumber;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    @Override
    public String toString() {
        return "TransactionLog{" +
                "clientId=" + clientId +
                ", senderAccountNumber='" + senderAccountNumber + '\'' +
                ", receiverAccountNumber='" + receiverAccountNumber + '\'' +
                ", date=" + date +
                ", amount=" + amount +
                '}';
    }
}
