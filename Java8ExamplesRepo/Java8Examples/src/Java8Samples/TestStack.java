package Java8Samples;

import java.util.Stack;

public class TestStack {

	private static Stack<String> intStack = new Stack<>();

	public static void main(String[] args) {
		intStack.push("fuck");
		intStack.push("you");
		intStack.pop();
		System.out.println(intStack.pop());
	}

}
