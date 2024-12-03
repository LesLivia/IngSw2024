package concurrent;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.TimeUnit;

public class BankAccountTest {

    @Test
    public void depositTest() throws InterruptedException {
        BankAccount ba = new BankAccount(100);
        A ba1 = new A(ba), ba2 = new A(ba);

        ba1.start();
        ba2.start();

        ba1.join();
        ba2.join();

        Assert.assertEquals(200, ba.getAmount());
    }

}
