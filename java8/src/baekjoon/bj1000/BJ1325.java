package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

//효율적인 해킹	(강결합 컴포넌트 연결(SCC)를 사용하면 더 빨리 가능함, 공부해야할것.)
public class BJ1325 {
	static List<List<Integer>> list;
	static boolean[] visited;
	static int[] results;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		
		list = new ArrayList<>(N + 1);	//신뢰관계 그래프
		visited = new boolean[N + 1];	//방문 체크 배열
		results = new int[N + 1];		//i번 컴퓨터를 해킹했을때 해킹 가능한 컴퓨터의 수
		
		for(int i = 1; i < N + 1; i++) {
			list.add(new ArrayList<>());	//linkedList로 만들면 시간초과남.
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken()), b = Integer.parseInt(st.nextToken());
			list.get(b).add(a);
		}
		
		int max = 0;
		for(int i = 1; i < N + 1; i++) {
			Arrays.fill(visited, false);	//방문 체크 배열 초기화
			visited[i] = true;	//i번째 컴퓨터 방문
			results[i] = solve(i);	//i번 컴퓨터로부터 해킹할 수 있는 모든 컴퓨터 수
			max = Math.max(max, results[i]);	//최대 해킹할 수 있는 컴퓨터 수
		}
//		System.out.println(Arrays.toString(results));
		for(int i = 1; i < N + 1; i++) {
			if(results[i] == max) {
				bw.write(i + " ");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	static int solve(int start) {	//dfs
		List<Integer> nexts = list.get(start);
		int result = 1;
		for(int i = 0; i < nexts.size(); i++) {
			if(!visited[nexts.get(i)]) {
				visited[nexts.get(i)] = true;
				result += solve(nexts.get(i));
			}
		}
		return result;
	}
}
