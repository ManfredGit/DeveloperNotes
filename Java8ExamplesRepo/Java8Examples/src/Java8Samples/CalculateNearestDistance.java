package Java8Samples;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
		
		Map<Point, Double> mapper = new HashMap<Point, Double>();
		
		coordinates.stream()
				.forEach(p -> {
					double distance = Math.sqrt(p.getX()*p.getX()+p.getY()*p.getY());
					mapper.put(p,distance);
				});

		Stream<Entry<Point, Double>> points = mapper.entrySet().stream()
				.sorted(Map.Entry.<Point, Double>comparingByValue())
				.limit(2);
		points.forEach(System.out::println);
		
		System.out.println("----------------");
		
		mapper.entrySet().stream()
			.sorted(Map.Entry.<Point, Double>comparingByValue())
			.limit(2)
			.map(p -> p.getKey()).collect(Collectors.toList())
			.forEach(System.out::println);

	}
	

}



