package kakao.kakao2019;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//3번 후보키 
public class CandidateKey {
	public static void main(String[] args) {
		String[][] relation = {
				{"100","ryan","music","2"},
				{"200","apeach","math","2"},
				{"300","tube","computer","3"},
				{"400","con","computer","1"},
				{"500","muzi","music","3"},
				{"600","apeach","music","2"}
		};
//		System.out.println(solution(relation));
		System.out.println(solution2(relation));
	}
	
	static int solution(String[][] relation) {
        int answer = 0;
        int n = relation[0].length, t = 0;
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i < (1 << n); i++) {
        	Set<String> set = new HashSet<>();
        	for(int k = 0; k < relation.length; k++) {
        		StringBuilder key = new StringBuilder();
	        	for(int j = 0; j < n; j++) {
	        		if((i & (1 << j)) > 0) {
	        			key.append(relation[k][j]);
	        		}
	        	}
	        	set.add(key.toString());
        	}
        	if(set.size() == relation.length) {
        		if(list.isEmpty()) {
        			list.add(i);
        		}else {
        			boolean flag = false;
        			for(Integer m : list) {
        				if(m == (m & i)) {
        					flag = true; 
        					break;
        				}
        			}
        			if(!flag) {
        				list.add(i);
        			}
        		}
        	}
        }
        return answer = list.size();
    }
	
	static int solution2(String[][] relation) {
		boolean[] chk = new boolean[relation[0].length];
		List<boolean[]> list = new ArrayList<>();
		recur(relation, list, chk, 0);
		return list.size() - 1;
	}
	
	static void recur(String[][] relation, List<boolean[]> list, boolean[] chk, int n) {
		if(n == chk.length) {
			Set<String> set = new HashSet<>();
			for(int i = 0; i < relation.length; i++) {
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < chk.length; j++) {
					if(chk[j]) {
						sb.append(relation[i][j]);
					}
				}
				set.add(sb.toString());
			}
			if(set.size() == relation.length) {
				
			}
			return;
		}
		recur(relation, list, chk, n + 1);
		chk[n] = true;
		recur(relation, list, chk, n + 1);
		chk[n] = false;
	}
}
