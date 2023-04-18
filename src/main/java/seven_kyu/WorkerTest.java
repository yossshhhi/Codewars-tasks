package seven_kyu;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

import org.junit.Assert;
import org.junit.Test;


public class WorkerTest {
    @Test
    public void SampleTests() {

        Worker w = new Worker();
        int counter = 20;
        AtomicInteger executionCounter = new AtomicInteger();

        Runnable action = () -> {
            System.out.print(".");
            executionCounter.incrementAndGet();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
        };
        w.execute(action, counter);

        int actualCounter = executionCounter.get();
        if (counter != actualCounter)
            System.out.println("Action was executed " + actualCounter + " times instead of " + counter + " times");
        Assert.assertEquals(counter, actualCounter);
    }
}
