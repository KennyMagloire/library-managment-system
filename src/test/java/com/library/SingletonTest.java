package com.library;

import com.library.patterns.singleton.DatabaseConnection;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SingletonTest {

    @Test
    public void testOnlyOneInstanceCreated() {
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        assertSame(db1, db2);
    }

    @Test
    public void testInstanceIsNotNull() {
        assertNotNull(DatabaseConnection.getInstance());
    }

    @Test
    public void testThreadSafety() throws InterruptedException {
        DatabaseConnection[] results = new DatabaseConnection[2];

        Thread t1 = new Thread(() -> results[0] = DatabaseConnection.getInstance());
        Thread t2 = new Thread(() -> results[1] = DatabaseConnection.getInstance());

        t1.start();
        t2.start();
        t1.join();
        t2.join();

        assertSame(results[0], results[1]);
    }
}