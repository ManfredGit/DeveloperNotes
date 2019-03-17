package Java8Samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import Java8Samples.model.Item;

public class StreamFilterSamples {
	public static void main(String[] args){
		List<Item> items = Arrays.asList(
				new Item("tea", 5, new Double("8.88")),
				new Item("coffee", 10, new Double("18.88")), 
				new Item("juice", 5, new Double("28.88")),
				new Item("milk", 5, new Double("28.88")), 
				new Item("water", 10, new Double("8.88")),
				new Item("tea", 5, new Double("8.88")), 
				new Item("coffee", 5, new Double("18.88")),
				new Item("milk", 30, new Double("48.88")),
				new Item("tea", 10, new Double("8.88")),
				new Item("water", 20, new Double("18.88")));
		
		//get sub list from original list as required filter
		System.out.println("-----remove tea-----------");
		List<Item> itemsels = new ArrayList<Item>();
		items.stream().filter(x -> x.getName()!="tea")
			.forEach((e) -> itemsels.add(e));
		itemsels.forEach(System.out::println);
		System.out.println("-----change to list-----------");
		items.stream().filter(x -> !"tea".equals(x.getName())).collect(Collectors.toList())
			.forEach(System.out::println);
		System.out.println("-----find any as required name match-----------");
		Item item1 = items.stream().filter(x -> "water".equals(x.getName())).findAny().orElse(null);
		System.out.println("---found item1="+item1);
		System.out.println("-----find any as required name  and quntity match-----------");
		Item item2 = items.stream().filter(
				(x) -> {
					if("tea".equals(x.getName()) && x.getQty()==10)
						return true;
					else 
						return false;
				}).findAny().orElse(null);
		System.out.println("---found item2="+item2);
		
		System.out.println("-----find all quntity is more tan 10------");
		items.stream().filter(Item::moreThan10).collect(Collectors.toList())
			.forEach(System.out::println);
		
		System.out.println("-----get name list-----------");
		List<String> names = items.stream()
				.filter(x -> !"tea".equals(x.getName()))
				.map(Item::getName)
				.distinct()
				.sorted()
				.collect(Collectors.toList());
		names.forEach(System.out::println);
	}

}
