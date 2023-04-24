package four_kyu;

import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

// https://www.codewars.com/kata/549e70e994e517ed8b00043e/java

public class ThreadedCounting {
    public static void countInThreads(Counter counter) {
        CountDownLatch latch = new CountDownLatch(1);


        Thread thread1 = new Thread(() -> {
            try {
                latch.await();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            IntStream.rangeClosed(1, 100)
                    .filter(i -> i % 3 == 0)
                    .forEach(i -> {
                        counter.count(i);
                        try {
                            Thread.sleep(600);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
        });
        Thread thread2 = new Thread(() -> {
            try {
                latch.await();
                Thread.sleep(200);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            IntStream.rangeClosed(1, 100)
                    .filter(i -> i % 3 == 1)
                    .forEach(i -> {
                        counter.count(i);
                        try {
                            Thread.sleep(600);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
        });
        Thread thread3 = new Thread(() -> {
            try {
                latch.await();
                Thread.sleep(400);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            IntStream.rangeClosed(1, 100)
                    .filter(i -> i % 3 == 2)
                    .forEach(i -> {
                        counter.count(i);
                        try {
                            Thread.sleep(600);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    });
        });

        thread1.start();
        thread2.start();
        thread3.start();

        latch.countDown();

        try {
            thread1.join();
            thread2.join();
            thread3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}

// in order for IntelliJ IDEA not to give an error
class Counter {
    public void count(int i) {

    }
}
