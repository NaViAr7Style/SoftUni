import org.junit.Before;
import org.junit.Test;

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
    public void testChangeTransactionStatusThrowsWhenMissing() {
        database.changeTransactionStatus(1, TransactionStatus.ABORTED);
    }

    @Test
    public void testGetByIdReturnsTheCorrectTransaction() {
        Transaction transaction = new TransactionImpl(1, TransactionStatus.SUCCESSFUL,
                "Dummy_1", "Dummy_2", 150.90);

        database.add(transaction);
        assertEquals(transaction, database.getById(1));
    }





























}