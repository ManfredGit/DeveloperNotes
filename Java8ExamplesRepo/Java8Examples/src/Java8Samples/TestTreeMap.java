package Java8Samples;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class TestTreeMap {
	public static TreeMap<String, Integer> tMap = new TreeMap<>();
	public static Map<String, Integer> hMap = new HashMap<>();
	public static Map<String, Integer> lMap = new LinkedHashMap<>();

	public static void main(String[] args) {
		tMap.put("three", 3);
		tMap.put("nine", 9);
		tMap.put("seven", 7);
		tMap.put("one", 1);
		hMap.put("one", 2);
		hMap.put("four", 4);
		hMap.put("six", 6);
		lMap.put("eight", 8);
		lMap.put("ten", 10);
		lMap.put("five", 5);

		System.out.println(tMap.toString());
		System.out.println(hMap.toString());
		System.out.println(lMap.toString());
	}
}