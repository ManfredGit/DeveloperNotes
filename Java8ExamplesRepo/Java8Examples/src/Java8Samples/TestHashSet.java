package Java8Samples;
import java.util.HashSet;
import java.util.Set;

public class TestHashSet {
	private int id;
	private String value;

	public TestHashSet(int id, String value) {
	  this.id = id;
	  this.value = value;
	 }

	public int getId() {
		return this.id;
	}

	public String getValue() {
		return this.value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		return result;
	}

	public static void main(String[] args) {
		Set<TestHashSet> set = new HashSet<TestHashSet>();
		TestHashSet test = new TestHashSet(1, "one");
		TestHashSet tes2 = new TestHashSet(1, "one");
		set.add(test);
		set.add(tes2);
		System.out.println("Size of set is - " + set.size());

	}
}