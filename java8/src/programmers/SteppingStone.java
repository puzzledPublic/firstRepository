package programmers;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

//징검다리
public class SteppingStone {
	public static void main(String[] args) {
		int[] distance = { 25, 65343245 };
		int[][] rocks = {
				{ 2, 14, 11, 21, 17 },
				{ 1229359, 14292516, 18119162, 7640178, 21475457, 13446983,
						10764311, 23677390, 16551566, 19637549, 15393700,
						13362406, 14808906, 1188568, 2430010, 995859, 6341191,
						13202229, 11128108, 21174736, 1931010, 9406546,
						17129598, 16279493, 11515655, 12283648, 18611563,
						10962958, 9331817, 19164215, 6816932, 15607344,
						18492487, 6655012, 16646986, 20600381, 22705607,
						3396266, 10239978, 14787853, 18843930, 12885894,
						21986321, 5327198, 13783223, 23728739, 1549474,
						8026301, 13229659, 8054873, 17599294, 4614842, 2902294,
						9898145, 15858474, 5860009, 21824861, 19465972,
						3521509, 15269292, 23708887, 16281697, 7936610,
						8545942, 20262894, 4297275, 12631814, 137872, 4613587,
						17270469, 18927526, 22213204, 19973483, 13639755,
						14210368, 11319843, 20736572, 10972250, 640276,
						22708998, 7109821, 9244360, 312786, 7084191, 8989726,
						5094591, 18371807, 23378634, 5074008, 718243, 12403800,
						9224735, 23212977, 3961579, 2549796, 1843642, 2242465,
						23140278, 5945922, 11818594, } };
		int[] n = { 2, 40 };
		for (int i = 0; i < distance.length; i++) {
			System.out.println(solution(distance[i], rocks[i], n[i]));
		}

	}
	
	static int solution(int distance, int[] rocks, int n) {
		int answer = 0;
		Map<String, Integer> map = new HashMap<>();
		Arrays.sort(rocks);
		System.out.print("0 ");
		for(int i = 0; i < rocks.length; i++) {
			System.out.print(rocks[i] + " ");
		}
		System.out.println(distance);
		
		System.out.print(rocks[0] + " ");
		for(int i = 1; i < rocks.length; i++) {
			System.out.print(rocks[i] - rocks[i - 1] + " ");
		}
		System.out.print(distance - rocks[rocks.length - 1]);
		System.out.println();
		
		
		return answer;
	}
}
