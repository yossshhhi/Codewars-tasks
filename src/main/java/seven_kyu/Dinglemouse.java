package seven_kyu;

public class Dinglemouse {
    private static class Logan5 implements Runnable {
        public void run() {
            System.out.println("Hello from Logan5");
            ThreadUtil.method1();
        }
    }

    private static class Jessica6 implements Runnable {
        public void run() {
            System.out.println("Hello from Jessica6");
            ThreadUtil.method2();
        }
    }

    public static void runRunners() {
        Thread logan = new Thread(new Logan5());
        Thread jessica = new Thread(new Jessica6());

        logan.start();
        jessica.start();

        try {
            logan.join();
            jessica.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    // in order for IntelliJ IDEA not to give an error
    class ThreadUtil {
        public static boolean checkThreads() {
            return true;
        }

        public static void method1() {}

        public static void method2() {}
    }
}
