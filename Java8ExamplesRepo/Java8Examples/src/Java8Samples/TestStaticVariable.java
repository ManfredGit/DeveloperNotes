package Java8Samples;

public class TestStaticVariable {
	private static int num = 0;

	private int num2 = 0;

	public TestStaticVariable() {
	  num += 10;
	  num2 += 10;
	 }

	public void m() {
		System.out.println("num in m() - " + num);
		System.out.println("num2 in m() - " + num2);
	}

	public static void main(String[] args) {
		TestStaticVariable test1 = new TestStaticVariable();
		test1.m();
		TestStaticVariable test2 = new TestStaticVariable();
		test2.m();
		TestStaticVariable test3 = new TestStaticVariable();
		test3.m();
	}
}