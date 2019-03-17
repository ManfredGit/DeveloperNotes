package Java8Samples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Java8Samples.model.Item;
import Java8Samples.model.PublicItem;

public class StreamSortBuilders {

	/**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i =1; i < 10; i++){
			list.add(i);
		}
		Stream<Integer> stream = list.stream();
		stream.forEach(System.out::println);
				
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
		
		items.forEach(System.out::println);
		System.out.println("-----distinct names-----------");
		items.stream().map(Item::getName).distinct().collect(Collectors.toList())
		.forEach(System.out::println);
		System.out.println("-----sorted names by name-----------");
		List<String> nameList = items.stream()
				.map((x) -> x.getName()).distinct().collect(Collectors.toList());
			//.forEach(System.out::println);
		Collections.sort(nameList);
		nameList.forEach(System.out::println);
		sortByPrice(items);
		sortByNameWithLambda(items);
		sortByPriceWithLambda(items);
		insideMap(items);
	}

	private static void insideMap(List<Item> items) {
		List<PublicItem> itemb = items.stream()
			.map( temp -> {
				PublicItem item = new PublicItem();
				item.setName(temp.getName());
				item.setQty(temp.getQty());
				if(temp.getName().contains("tea")){
					item.setExtra("green tea");
				}
				if(temp.getName().contains("water")){
					item.setExtra("bottle water");
				}
				return item;
			}).collect(Collectors.toList());
		itemb.forEach(System.out::println);
		
	}

	private static void sortByNameWithLambda(List<Item> items) {		
		System.out.println("-----sorted items by name with lambda-----------");
		items.sort((o1,o2)->o1.getName().compareTo(o2.getName()));
		items.forEach(System.out::println);
	}

	private static void sortByPriceWithLambda(List<Item> items) {

		System.out.println("-----sorted items by price with lambda-----------");
		Comparator<Item> priceComparator = (o1,o2)->o1.getPrice().compareTo(o2.getPrice());
		//items.sort(priceComparator.reversed());
		//items.forEach(System.out::println);
		items.stream().sorted(priceComparator).forEach(System.out::println);
		System.out.println("-----reversed sorted by price---");
		items.stream().sorted(priceComparator.reversed()).forEach(System.out::println);
		
	}

	private static void sortByPrice(List<Item> items) {
		Collections.sort(items, new Comparator<Item>(){

			@Override
			public int compare(Item item1, Item item2) {
				//return (int) ((item1.getPrice()-item2.getPrice())*1000);
				return  item1.getPrice().compareTo(item2.getPrice());
			}
			
		});
		System.out.println("-----sorted items by price-----------");
		items.forEach(System.out::println);
	}

}
