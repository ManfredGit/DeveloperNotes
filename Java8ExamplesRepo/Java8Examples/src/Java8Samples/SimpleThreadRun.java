package Java8Samples;
interface Executable{
		void execute();
}

class Runner{
	public void run(Executable e){
		System.out.println("Executing code block...");
		e.execute();
	}
}

public class SimpleThreadRun {

	public static void main(String[] args) {
		Runner runner = new Runner();
//		runner.run(new Executable(){
//			public void execute(){
//				System.out.println("Hello there.");
//			}
//		});
		System.out.println("============================");
		
		runner.run(()-> System.out.println("Hello buddy"));
	}

}
