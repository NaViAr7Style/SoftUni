import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL,
                "Dummy_1", "Dummy_2", 150.90);

        database.add(transaction);
        assertEquals(1, database.getCount());
        assertTrue(database.contains(transaction));
    }

    @Test
    public void testAddExistingTransaction() {
        assertEquals(0, database.getCount());
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL,
                "Dummy_1", "Dummy_2", 150.90);

        database.add(transaction);
        database.add(transaction);
        assertEquals(1, database.getCount());
        assertTrue(database.contains(transaction.getId()));
    }

    @Test
    public void testChangeTransactionStatusChangesStatus() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL,
                "Dummy_1", "Dummy_2", 150.90);

        database.add(transaction);
        database.changeTransactionStatus(1, TransactionStatus.ABORTED);
        assertEquals(TransactionStatus.ABORTED, transaction.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testChangeTransactionStatusThrowsWhenTxIsMissing() {
        database.changeTransactionStatus(1, TransactionStatus.ABORTED);
    }

    @Test
    public void testRemoveTransactionByIdRemovesCorrectTransaction() {
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL,
                "Dummy_1", "Dummy_2", 150.90);

        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED,
                "Dummy_3", "Dummy_4", 50.55);

        database.add(transaction1);
        database.add(transaction2);

        database.removeTransactionById(1);

        assertEquals(1, database.getCount());
        assertFalse(database.contains(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTransactionByIdThrowsWhenTxIsMissing() {
        database.removeTransactionById(1);
    }

    @Test
    public void testGetByIdReturnsTheCorrectTransaction() {
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL,
                "Dummy_1", "Dummy_2", 150.90);

        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED,
                "Dummy_3", "Dummy_4", 50.55);

        database.add(transaction1);
        database.add(transaction2);

        assertEquals(transaction1, database.getById(1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIdThrowsWhenTxIsMissing() {
        database.getById(1);
    }

    @Test
    public void testGetByTransactionStatusReturnsTheCorrectTransactions() {
        Transaction transaction1 = new TransactionImpl(1, TransactionStatus.SUCCESSFUL,
                "Dummy_1", "Dummy_2", 40.90);

        Transaction transaction2 = new TransactionImpl(2, TransactionStatus.ABORTED,
                "Dummy_3", "Dummy_4", 50.55);

        Transaction transaction3 = new TransactionImpl(3, TransactionStatus.SUCCESSFUL,
                "Dummy_5", "Dummy_6", 85.45);

        Transaction transaction4 = new TransactionImpl(4, TransactionStatus.SUCCESSFUL,
                "Dummy_5", "Dummy_6", 65.00);

        database.add(transaction1);
        database.add(transaction2);
        database.add(transaction3);
        database.add(transaction4);

        List<Transaction> expected = new ArrayList<>();
        expected.add(transaction3);
        expected.add(transaction4);
        expected.add(transaction1);

        Iterable<Transaction> result = database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
        List<Transaction> actual = new ArrayList<>();
        result.forEach(actual::add);

        assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByTransactionStatusThrowsWhenThereAreNoTxsWithThatStatus() {
        database.getByTransactionStatus(TransactionStatus.SUCCESSFUL);
    }

}
















