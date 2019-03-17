package Java8Samples;

public class Test05_C extends Test05_B {

	@Override
	public void display() {
		System.out.println("Class C");
	}
	
	public void print_c(){
		System.out.println("Print Class C");
	}

	public static void main(String[] args) {
		Test05_C c = new Test05_C();
		Test05_B b = c;
		//Test05_A a = new Test05_A();
//		a = (Test05_B) c;
//		a.display();
		b.display();
		c.display();
	}
}
