package Java8Samples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import Java8Samples.model.Point;

public class CalculateNearestDistance {
	
	//given coordinates (1,-3),(3,4),(-1,2),(1,2),(2,3), 
	//calcaulate the nearest 2(or num) points from origin (0,0)
	public static void main(String[] args){
		List<Point> coordinates = Arrays.asList(
				new Point(1,-3),
				new Point(3,4),
				new Point(-1,4),
				new Point(1,2),
				new Point(2,3)
			);
		
		int num = 2;
		Map<Point, Double> mapper = new HashMap<Point, Double>();
		
		coordinates.stream()
				.forEach(p -> {
					double distance = Math.sqrt(p.getX()*p.getX()+p.getY()*p.getY());
					mapper.put(p,distance);
				});

		Stream<Entry<Point, Double>> points = mapper.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.limit(2);
		points.forEach(System.out::println);
		
		System.out.println("---get coordinate list-------------");
		
		mapper.entrySet().stream()
			.sorted(Map.Entry.comparingByValue())
			.limit(num)
			.map(p -> p.getKey()).collect(Collectors.toList())
			.forEach(System.out::println);

        System.out.println("-----Sorted Map...");
        // sort by values, distance, and return a new LinkedHashMap
        // toMap() will returns HashMap by default, we need LinkedHashMap to keep the order.
		LinkedHashMap<Point, Double> result = mapper.entrySet().stream()
				.sorted(Map.Entry.comparingByValue())
				.limit(num)
				.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
        System.out.println(result);
        
        System.out.println("-----toMap and then sorted...");
        Map<Point, Double> result_map = coordinates.stream()
        .collect(Collectors.toMap(Function.identity(), p -> Math.sqrt(p.getX()*p.getX()+p.getY()*p.getY())));
        
        LinkedHashMap<Point, Double> output = result_map.entrySet().stream()
        		.sorted(Map.Entry.comparingByValue()).limit(num)
        		.collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
        				(oldValue, newValue) -> oldValue, LinkedHashMap::new));
        
        System.out.println(output);
	}
	

}



