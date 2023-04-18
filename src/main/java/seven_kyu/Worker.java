package seven_kyu;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Worker {
    public void execute(Runnable action, int nTimes) {
        int nThreads = 100;
        if (nTimes > 100)
            nThreads = 1000;
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        for (int i = 0; i < nTimes; i++) {
            executorService.submit(action);
        }
        executorService.shutdown();
        try {
            executorService.awaitTermination(1, TimeUnit.DAYS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
