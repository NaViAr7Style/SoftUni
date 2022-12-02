package p02_ExtendedDatabase;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    Database database;
    private final static Person DUMMY1 = new Person(1, "Dummy1");
    private final static Person DUMMY2 = new Person(1, "Dummy2");
    private final static Person DUMMY3 = new Person(1, "Dummy3");

    @Before
    public void setup() throws OperationNotSupportedException {
        database = new Database(DUMMY1, DUMMY2, DUMMY3);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowWithNull() throws OperationNotSupportedException {
        database.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindByUsernameShouldThrowIfMissing() throws OperationNotSupportedException {
        database.findByUsername("dummy");
    }

    @Test
    public void testFindByUsernameShouldReturnUser() throws OperationNotSupportedException {
        Person person = database.findByUsername(DUMMY1.getUsername());
        assertEquals(person.getId(), DUMMY1.getId());
        assertEquals(person.getUsername(), DUMMY1.getUsername());
    }


}