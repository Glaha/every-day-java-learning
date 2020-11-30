import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreTest {

  public static void main(String[] args) {
    ExecutorService threadPool = Executors.newCachedThreadPool();

    final Semaphore semaphore = new Semaphore(5);

    for (int i = 0; i < 20; i++) {
      final int tmp = i;
      Runnable runnable =
          () -> {
            try {
              semaphore.acquire();
              System.out.println("acquired semaphore: " + tmp);
              Thread.sleep((long) (Math.random() * 10000));
              semaphore.release();
              System.out.println("--------------" + semaphore.availablePermits());
            } catch (InterruptedException e) {
              e.printStackTrace();
            }
          };
      threadPool.execute(runnable);
    }

    threadPool.shutdown();
  }
}
