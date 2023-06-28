import java.util.concurrent.CountDownLatch;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import six_kyu.VisitorStatistics;

public class VisitorStatisticsTest {
    private VisitorStatistics visitorStatistics;

    @Before
    public void setUp() throws Exception {

        visitorStatistics = new VisitorStatistics();
    }

    @Test
    public void shouldIncrementCounterAndTrackUsers() throws Exception {

        visitorStatistics.visit("A");
        visitorStatistics.visit("B");
        visitorStatistics.visit("A");
        Assert.assertEquals("wrong number of total visits", 3, visitorStatistics.totalVisits());
        Assert.assertEquals("wrong number of visits by A", 2, visitorStatistics.visitsBy("A"));
        Assert.assertEquals("wrong number of visits by B", 1, visitorStatistics.visitsBy("B"));
    }

    @Test
    public void shouldHandleConcurrentAccess() throws Exception {

        CountDownLatch latch = new CountDownLatch(1);
        Thread[] threads = new Thread[100];
        String name = "Visitor";
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                try {
                    latch.await();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                visitorStatistics.visit(name);
            });
            threads[i].start();
        }
        latch.countDown();
        for (Thread thread : threads) {
            thread.join();
        }
        Assert.assertEquals(threads.length, visitorStatistics.totalVisits());
        Assert.assertEquals(threads.length, visitorStatistics.visitsBy(name));
    }
}
