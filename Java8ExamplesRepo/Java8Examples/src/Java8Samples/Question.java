package Java8Samples;

public class Question {
	public static void JavaHungry(Exception e){
		System.out.println("Exception");
	}
	public static void JavaHungry(Object o){
		System.out.println("Object");
	}
	public static void JavaHungry(ArithmeticException ae){
		System.out.println("ArithmeticException");
	}
	
	public static void main(String [] args){
		short s = 0;
		int z = 123;
		s += z;
		System.out.println("Java Hungry s="+s);
		JavaHungry(null);
		if(null==null){
			System.out.println("Java Hungry");
		}
	}
}
