package TransactionDataModel;

import java.util.Iterator;

public class Main {
	    private static TransactionHistory someCollection;

		public static void main(String[] args) {
	    	
	        TransactionHistory transactionHistory = new TransactionHistory();
	        TransactionProcessor transactionProcessor = new TransactionProcessor(transactionHistory);
	        
	     // Start producer and consumer threads
	        transactionProcessor.startProducers(2); // Start 2 producer threads
	        transactionProcessor.startConsumers(3); // Start 3 consumer threads
	        
	        
	        // Adding transactions
	        transactionHistory.add(new Transaction("Deposit", 100.0));
	        transactionHistory.add(new Transaction("Withdrawal", 200.0));

	        // Iterating over transactions
	        System.out.println("Transactions:");
	        for (Transaction transaction : transactionHistory) {
	            System.out.println(transaction);
	        }

	        // Removing a transaction
	        transactionHistory.remove(0);

	        // Checking size
	        System.out.println("Number of transactions: " + transactionHistory.size());
	        
	        Iterator<Transaction> iterator = someCollection.iterator();
	        if (iterator != null) {
	            while (iterator.hasNext()) {
	            }
	        } else {
	            // Handle the case where the collection is null
	        }

	        System.out.println("Transactions:");
	        for (Transaction transaction : transactionHistory) {
	            System.out.println(transaction);
	    }
	}
}
