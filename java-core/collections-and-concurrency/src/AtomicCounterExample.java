import java.lang.ref.PhantomReference;
import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounterExample {
    private static AtomicInteger counter = new AtomicInteger(0);

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(()-> {
            for (int i = 0; i < 100_000; i++) {
                counter.incrementAndGet();
            }
        });
        

        Thread thread2= new Thread(()-> {
            for (int i = 0; i < 100_000; i++) {
                counter.incrementAndGet();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(counter);
        System.gc();
        System.out.println(counter);
    }
}
