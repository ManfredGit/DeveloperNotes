package Java8Samples;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestExecutors {

	public static void main(String[] args) {
		ExecutorService executors = Executors.newFixedThreadPool(3);
		for (int i = 0; i < 10; i++) {
			Runnable worker = new WorkerThread("" + i);
			executors.execute(worker);
		}
		executors.shutdown();
		while(!executors.isTerminated()){
			
		}
		System.out.println("Finished all threads");
	}

}
