import java.util.*;
import java.util.stream.Collectors;

public class ChainblockImpl implements Chainblock{

    private final Map<Integer, Transaction> transactionMap;

    public ChainblockImpl() {
        transactionMap = new HashMap<>();
    }



    public int getCount() {
        return transactionMap.size();
    }

    public void add(Transaction transaction) {
        transactionMap.putIfAbsent(transaction.getId(), transaction);
    }

    public boolean contains(Transaction transaction) {
        return transactionMap.containsKey(transaction.getId());
    }

    public boolean contains(int id) {
        return transactionMap.containsKey(id);
    }

    public void changeTransactionStatus(int id, TransactionStatus newStatus) {
        ensureTxIsPresent(id);
        transactionMap.get(id).setStatus(newStatus);
    }



    public void removeTransactionById(int id) {
        ensureTxIsPresent(id);
        transactionMap.remove(id);
    }

    public Transaction getById(int id) {
        ensureTxIsPresent(id);
        return transactionMap.get(id);
    }

    public Iterable<Transaction> getByTransactionStatus(TransactionStatus status) {
        List<Transaction> filteredTransactions = transactionMap.values().stream()
                .filter(tr -> tr.getStatus().equals(status))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        ensureCollectionIsNotEmpty(filteredTransactions);

        return filteredTransactions;
    }

    public Iterable<String> getAllSendersWithTransactionStatus(TransactionStatus status) {
        Iterable<Transaction> filteredTransactions = getByTransactionStatus(status);

        List<String> senders = new ArrayList<>();

        filteredTransactions.forEach(tr -> senders.add(tr.getFrom()));

        ensureCollectionIsNotEmpty(senders);

        return senders;
    }

    public Iterable<String> getAllReceiversWithTransactionStatus(TransactionStatus status) {
        return null;
    }

    public Iterable<Transaction> getAllOrderedByAmountDescendingThenById() {
        return null;
    }

    public Iterable<Transaction> getBySenderOrderedByAmountDescending(String sender) {
        return null;
    }

    public Iterable<Transaction> getByReceiverOrderedByAmountThenById(String receiver) {
        return null;
    }

    public Iterable<Transaction> getByTransactionStatusAndMaximumAmount(TransactionStatus status, double amount) {
        return null;
    }

    public Iterable<Transaction> getBySenderAndMinimumAmountDescending(String sender, double amount) {
        return null;
    }

    public Iterable<Transaction> getByReceiverAndAmountRange(String receiver, double lo, double hi) {
        return null;
    }

    public Iterable<Transaction> getAllInAmountRange(double lo, double hi) {
        return null;
    }

    public Iterator<Transaction> iterator() {
        return null;
    }

    private void ensureTxIsPresent(int id) {
        if (!transactionMap.containsKey(id)) {
            throw new IllegalArgumentException("Invalid transaction ID!");
        }
    }

    private static void ensureCollectionIsNotEmpty(List list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("There are no transactions with the selected status!");
        }
    }
}
