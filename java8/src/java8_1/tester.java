package java8_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class tester {

	public static void main(String args[]) throws JsonGenerationException, JsonMappingException, IOException
	{ 
		ArrayList<String> list = new ArrayList<>();
		
		list.add("hell");
		list.add("hell");
		list.add("hell");
		list.add("ertret");
		list.add("gogogogogogogo");
		/*
		list.stream()
			.distinct()
			.forEach(System.out::println);
		
		System.out.println();
		
		list.stream()
			.distinct()
			.sorted(Comparator.comparing(String::length).reversed())
			.forEach(System.out::println);
			
		//Stream.generate(Math::random).limit(10).forEach(x->{x=x*10+1; System.out.println(x.intValue());});
		
		Optional<Double> t = Stream.generate(Math::random).limit(10).map(x->x=x*10+1).max((x,y)->{return (int) (x-y);});
		System.out.println(t.orElse(Double.valueOf("0")).intValue());
		
		IntSummaryStatistics summary = list.stream().collect(Collectors.summarizingInt(String::length));
		System.out.println("average: "+summary.getAverage()+" max: "+summary.getMax());
	*/
		ObjectMapper om = new ObjectMapper();
		
		System.out.println(om.writeValueAsString(list));
	}
}
