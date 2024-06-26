package TransactionDataModel;

	import java.util.UUID;

	public class Transaction {
	    private String transactionId;
	    private long timestamp;
	    private String transactionType;
	    private double amount;

	    // Constructor
	    public Transaction(String transactionType, double amount) {
	        this.transactionId = UUID.randomUUID().toString(); // Generate unique transaction ID
	        this.timestamp = System.currentTimeMillis(); // Timestamp when the transaction is created
	        this.transactionType = transactionType;
	        this.amount = amount;
	    }

	    // Getters
	    public String getTransactionId() {
	        return transactionId;
	    }

	    public long getTimestamp() {
	        return timestamp;
	    }

	    public String getTransactionType() {
	        return transactionType;
	    }

	    public double getAmount() {
	        return amount;
	    }

	    // Override toString() to provide a string representation of the transaction
	    @Override
	    public String toString() {
	        return "Transaction{" + "transactionId='" + transactionId + '\'' +", timestamp=" +
	        	 timestamp +", transactionType='" + transactionType + '\'' + ", amount=" + amount +'}';
	      
	    }
	}


