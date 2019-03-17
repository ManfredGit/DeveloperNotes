package Java8Samples;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import Java8Samples.model.Item;

public class CollectGroupBy {

	public static void main(String[] args) {
		List<Item> items = Arrays.asList(
				new Item("tea", 5, new Double("8.88")),
				new Item("coffee", 10, new Double("18.88")), 
				new Item("juice", 5, new Double("28.88")),
				new Item("milk", 5, new Double("28.88")), 
				new Item("water", 10, new Double("8.88")),
				new Item("tea", 5, new Double("8.88")), 
				new Item("coffee", 5, new Double("18.88")),
				new Item("tea", 10, new Double("8.88")),
				new Item("water", 20, new Double("18.88")));
		
		StringCollection();
		System.out.println("----------------");
		ObjectCollection(items);
		System.out.println("----------------");
		GroupByPrice(items);
		System.out.println("----------------");
	}


	private static void StringCollection() {
		// 3 tea, 2 coffee, others 1
		List<String> items = Arrays.asList("tea", "tea", "coffee", "tea", "juice", "milk", "coffee", "water");

		Map<String, Long> result = items.stream()
				.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

		System.out.println(result);

		Map<String, Long> finalMap = new LinkedHashMap<>();
		// Sort a map and add to finalMap
		result.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));

		System.out.println(finalMap);
	}

	private static void ObjectCollection(List<Item> items) {

		Map<String, Long> countings = items.stream()
				.collect(Collectors.groupingBy(Item::getName, Collectors.counting()));
		System.out.println("countings:");
		System.out.println(countings);

		Map<String, Long> finalMap = new LinkedHashMap<>();
		// Sort a map and add to finalMap
		countings.entrySet().stream().sorted(Map.Entry.<String, Long>comparingByValue().reversed())
				.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
		System.out.println("sorted countings:");
		System.out.println(finalMap);
		
		
        Map<String, Integer> qty_sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingInt(Item::getQty)));
        System.out.println("qty_sum:");
        System.out.println(qty_sum);
        
        Map<String, Double> price_sum = items.stream().collect(
                Collectors.groupingBy(Item::getName, Collectors.summingDouble(Item::getPrice)));
        System.out.println("price_sum:");
        System.out.println(price_sum);
	}
	

	private static void GroupByPrice(List<Item> items) {

		//group by price
		Map<Double, List<Item>> groupbyPriceMap 
			= items.stream().collect(Collectors.groupingBy(Item::getPrice));
        System.out.println("groupbyPriceMap:");
        System.out.println(groupbyPriceMap);
        
       // group by price, uses 'mapping' to convert List<Item> to Set<String>
        Map<Double, Set<String>> result = 
        		items.stream().collect(
        				Collectors.groupingBy( 
        						Item::getPrice, Collectors.mapping(Item::getName, Collectors.toSet())
        				)
        		);
        System.out.println("mappingToString:");
        System.out.println(result);   
        
	}

}
