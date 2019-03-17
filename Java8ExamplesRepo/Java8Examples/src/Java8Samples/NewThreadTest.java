package Java8Samples;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class NewThreadTest {

	public static void main(String[] args) {
		Runnable task = () -> {
			try {
				String threadName = Thread.currentThread().getName();
				TimeUnit.SECONDS.sleep(1);
				// Thread.sleep(1000);
				System.out.println("Hello " + threadName);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};

		Thread thread = new Thread(task);
		thread.start();
		System.out.println("Done!");

		Callable<Integer> taskCall = () -> {
			try {
				TimeUnit.SECONDS.sleep(1);
				return 123;
			} catch (InterruptedException e) {
				throw new IllegalStateException("task interrupted", e);
			}
		};

		ExecutorService executor = Executors.newSingleThreadExecutor();
		executor.submit(() -> {
			String threadName = Thread.currentThread().getName();
			System.out.println("ExecutorService, Hello - " + threadName);
		});

		Runnable worker = new WorkerThread("ExecutorService");
		// executor.execute(worker);
		executor.submit(worker);
		executor.submit(task);
		try {
			Future<Integer> f = executor.submit(taskCall);
			System.out.println("Future="+f.isDone());
			Integer result = f.get();
			System.out.println("Future="+f.isDone());
			System.out.println("result="+result);
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		try {
			System.out.println("attempt to shutdown executor");
			executor.shutdown();
			executor.awaitTermination(5, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("tasks interrupted");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("cancel non-finished tasks");
			}
			executor.shutdownNow();
			System.out.println("shutdown finished");
		}

	}
}
