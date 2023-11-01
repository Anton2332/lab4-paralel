import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(() -> {
            try {
                counter.increment();
                System.out.println("Thread 1: " + counter.value());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                counter.increment();
                System.out.println("Thread 2: " + counter.value());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        thread1.start();
        thread2.start();

        // Counter counter = new Counter();
        // Lock lock = new ReentrantLock();

        // Thread thread1 = new Thread(() -> {
        //     try {
        //         if (lock.tryLock(10, TimeUnit.SECONDS)) {
        //             counter.increment();
        //             System.out.println("Thread 1: " + counter.value());
        //         }
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     } finally {
        //         lock.unlock();
        //     }
        // });

        // Thread thread2 = new Thread(() -> {
        //     try {
        //         if (lock.tryLock(10, TimeUnit.SECONDS)) {
        //             counter.increment();
        //             System.out.println("Thread 2: " + counter.value());
        //         }
        //     } catch (InterruptedException e) {
        //         e.printStackTrace();
        //     } finally {
        //         lock.unlock();
        //     }
        // });

        // thread1.start();
        // thread2.start();
    }
}
