package EmailGen;

import java.util.Date;

public class Transaction {

    // Transactions have date, quantity and transaction type
    private final Date timestamp;
    private final int quantity;
    String type;

    // Transaction constructor
    public Transaction (String type, int quantity) {
        this.timestamp = new Date();
        this.quantity = quantity;
        this.type = type;
    }

    // Getters
    public String getType() {
        return this.type;
    }
    public int getQuantity() {
        return this.quantity;
    }
    public Date getTimestamp() {
        return this.timestamp;
    }
}
