package Java8Samples;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TestCallable {

	static Callable<String> callable(String result, long sleepSeconds) {
		return () -> {
			TimeUnit.SECONDS.sleep(sleepSeconds);
			return result;
		};
	}

	public static void main(String[] args) {
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable<String>> callables = Arrays.asList(() -> "task1", () -> "task2", () -> "task3");

		try {
			executor.invokeAll(callables).stream().map(future -> {
				try {
					return future.get();
				} catch (Exception e) {
					throw new IllegalStateException(e);
				}
			}).forEach(x -> System.out.println("running result 1 ="+x));
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		List<Callable<String>> callables2 = Arrays.asList(callable("task21", 1), callable("task22", 2),
				callable("task23", 3));

		String result = null;
		try {
			result = executor.invokeAny(callables2);
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		System.out.println("running result 2 ="+result);

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
