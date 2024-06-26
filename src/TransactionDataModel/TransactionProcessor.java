package TransactionDataModel;

	import java.util.concurrent.BlockingQueue;
	import java.util.concurrent.LinkedBlockingQueue;

	public class TransactionProcessor {
	    private BlockingQueue<Transaction> transactionQueue;
	    private TransactionHistory transactionHistory;

	    public TransactionProcessor(TransactionHistory transactionHistory) {
	        this.transactionQueue = new LinkedBlockingQueue<>();
	        this.transactionHistory = transactionHistory;
	    }

	    // Method to start producer threads
	    public void startProducers(int numProducers) {
	        for (int i = 0; i < numProducers; i++) {
	            Thread producerThread = new Thread(new TransactionProducer());
	            producerThread.start();
	        }
	    }

	    // Method to start consumer threads
	    public void startConsumers(int numConsumers) {
	        for (int i = 0; i < numConsumers; i++) {
	            Thread consumerThread = new Thread(new TransactionConsumer());
	            consumerThread.start();
	        }
	    }

	    // Producer thread class
	    private class TransactionProducer implements Runnable {
	        @Override
	        public void run() {
	            try {
	                while (true) {
	                    Transaction transaction = generateRandomTransaction();
	                    transactionQueue.put(transaction);
	                    System.out.println("Produced transaction: " + transaction);
	                    Thread.sleep(1000); // Simulate some processing time
	                }
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }

	        private Transaction generateRandomTransaction() {
	            // Generate random transaction details (for simplicity, hardcoded)
	            return new Transaction("Type", Math.random() * 1000);
	        }
	    }

	    // Consumer thread class
	    private class TransactionConsumer implements Runnable {
	        @Override
	        public void run() {
	            try {
	                while (true) {
	                    Transaction transaction = transactionQueue.take();
	                    processTransaction(transaction);
	                }
	            } catch (InterruptedException e) {
	                Thread.currentThread().interrupt();
	            }
	        }

	        private void processTransaction(Transaction transaction) {
	            // Example processing: Print to console and add to history
	            System.out.println("Consumed transaction: " + transaction);
	            transactionHistory.add(transaction);
	        }
	    }
	}


