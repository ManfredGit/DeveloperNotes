package Java8Samples;

public class ThreadJob extends Thread {
	private int counter = 0;
	private static int num = 0;

	@Override
	public void run() {
		synchronized (this) {
			for (int i = 0; i < 10; i++) {
				counter++;
				num++;
				this.notifyAll();
				System.out.println("Completed Counting..." + Thread.currentThread().getName());

			}
		}
	}

	public static void main(String[] args) throws InterruptedException {
		ThreadJob job1 = new ThreadJob();
		job1.start();
		ThreadJob job2 = new ThreadJob();
		job2.start();
		Thread.sleep(100);
		System.out.println("Waiting to get end...");
		// synchronized(job1){
		// job1.wait();
		// }
		System.out.println("counter=" + job1.counter);
		System.out.println("counter=" + job2.counter);
		System.out.println("num=" + ThreadJob.num);

	}

}
