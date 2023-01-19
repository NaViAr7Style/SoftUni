import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class ChainblockImplTest {

    private Chainblock database;

    @Before
    public void setUp() {
        database = new ChainblockImpl();
    }

    @Test
    public void testAddTransaction() {
        assertEquals(0, database.getCount());
        Transaction transaction = addOneTransaction();
        assertEquals(1, database.getCount());
        assertTrue(database.contains(transaction));
    }

    @Test
    public void testAddExistingTransaction() {
        assertEquals(0, database.getCount());
        Transaction transaction = addOneTransaction();
        database.add(transaction);
        assertEquals(1, database.getCount());
        assertTrue(database.contains(transaction.getId()));
    }

    @Test
    public void testChangeTransactionStatusChangesStatus() {
        Transaction transaction = addOneTransaction();
        database.changeTransactionStatus(1, TransactionStatus.ABORTED);
        assertEquals(TransactionStatus.ABORTED, transaction.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusThrowsWhenTxIsMissing() {
        database.changeTransactionStatus(1, TransactionStatus.ABORTED);
    }

    @Test
    public void testRemoveTransactionByIdRemovesCorrectTransaction() {
        addOneTransaction();
        addMultipleTransactions();

        int sizeBeforeRemoval = database.getCount();

        database.removeTransactionById(1);

        int sizeAfterRemoval = database.getCount();

        assertEquals(sizeBeforeRemoval - 1, sizeAfterRemoval);
        assertFalse(database.contains(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdThrowsWhenTxIsMissing() {
        database.removeTransactionById(1);
    }

    @Test
    public void testGetByIdReturnsTheCorrectTransaction() {
        Transaction transaction = addOneTransaction();
        addMultipleTransactions();

        assertEquals(transaction, database.getById(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdThrowsWhenTxIsMissing() {
        database.getById(1);
    }

    @Test
    public void testGetByTransactionStatusReturnsTheCorrectTransactionsSorted() {
        List<Transaction> transactions = addMultipleTransactions();

        List<Transaction> expected = transactions.stream()
                .filter(tr -> tr.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .collect(Collectors.toList());

        Iterable<Transaction> result = database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusThrowsWhenThereAreNoTxsWithThatStatus() {
        database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

    @Test
    public void testGetAllSendersWithTransactionStatusReturnsTheCorrectSenders() {
        Transaction transaction = addOneTransaction();
        List<Transaction> transactions = addMultipleTransactions();
        transactions.add(transaction);

        List<String> expected = transactions.stream()
                .filter(tr -> tr.getStatus().equals(TransactionStatus.SUCCESSFUL))
                .sorted(Comparator.comparing(Transaction::getAmount).reversed())
                .map(Transaction::getFrom)
                .collect(Collectors.toList());

        Iterable<String> result = database.getAllSendersWithTransactionStatus(TransactionStatus.SUCCESSFUL);
        assertNotNull(result);
        List<String> actual = new ArrayList<>();
        result.forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetAllSendersWithTransactionStatusThrowsWhenThereAreNoTxsWithThatStatus() {
        addMultipleTransactions();
        database.getAllSendersWithTransactionStatus(TransactionStatus.UNAUTHORIZED);
    }





    private Transaction addOneTransaction() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL,
                "Dummy_1", "Dummy_2", 45.50);

        database.add(transaction);
        return transaction;
    }

    private List<Transaction> addMultipleTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED,
                "Dummy_2", "Dummy_4", 50.55);

        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL,
                "Dummy_3", "Dummy_18", 85.45);

        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.SUCCESSFUL,
                "Dummy_4", "Dummy_22", 65.00);

        Transaction transaction5 = new TransactionImpl(5, TransactionStatus.FAILED,
                "Dummy_5", "Dummy_43", 12.25);

        transactions.add(transaction2);
        transactions.add(transaction3);
        transactions.add(transaction4);
        transactions.add(transaction5);

        transactions.forEach(database::add);

        return transactions;
    }

}
















