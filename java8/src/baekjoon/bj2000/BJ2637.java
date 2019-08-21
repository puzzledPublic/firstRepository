package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

//장난감 조립
public class BJ2637 {
	static int[] indegree;
	static int[] copyDegree;
	static int[][] fromTo;
	static List<List<Integer>> graph = new ArrayList<>();
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		indegree = new int[N + 1];
		copyDegree = new int[N + 1];
		fromTo = new int[N + 1][N + 1];
		for(int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		
		int M = Integer.parseInt(br.readLine());
		for(int i = 0; i < M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			fromTo[Y][X] = K;
			indegree[X]++;
			copyDegree[X]++;
			graph.get(Y).add(X);
		}
				
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= N; i++) {
			if(indegree[i] == 0) {
				queue.add(i);
			}
		}
		
		while(!queue.isEmpty()) {
			int curr = queue.poll();
			
			for(int next : graph.get(curr)) {
				indegree[next]--;
				for(int i = 1; i <= N; i++) {
					fromTo[i][next] += (fromTo[i][curr] * fromTo[curr][next]);
				}
				if(indegree[next] == 0) {
					queue.add(next);
				}
			}
		}
		
		for(int i = 1; i <= N; i++) {
			if(copyDegree[i] == 0) {
				bw.write(i + " " + fromTo[i][N] + "\n");
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
