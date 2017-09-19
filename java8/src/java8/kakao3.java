package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class kakao3 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String[] str = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
		System.out.println(solution(5, str));
		
	}
	static int solution(int cacheSize, String[] cities){
		int answer = 0;
		List<String> cache = new ArrayList<>();
		int[] lru = new int[cacheSize];
		
		if(cacheSize == 0){
			return cities.length * 5;
		}
		for(int i = 0 ; i < cacheSize; i++){
			lru[i] = cacheSize - i - 1;
		}
		
		for(int i = 0 ; i < cities.length ; i++){
			if(cache.contains(cities[i].toLowerCase())){
				lru[cache.indexOf(cities[i].toLowerCase())] = 0;
				answer +=1;
			}else{
				int max = lru[0];
				int index = 0;
				for(int j = 1; j < lru.length; j++){
					if(max < lru[j]){
						max = lru[j];
						index = j;
					}
				}
				for(int j = 0 ; j < lru.length; j++){
					lru[j]++;
				}
				lru[index] = 0;
				if(cache.size() < cacheSize){
					cache.add(index, cities[i].toLowerCase());
				}
				else{
					cache.set(index, cities[i].toLowerCase());
				}
				answer +=5;

			}
			for(int j = 0 ; j < cache.size(); j++){
				System.out.print(cache.get(j)+" ");
			}
			System.out.println();
		}
		
		return answer;
	}
}
