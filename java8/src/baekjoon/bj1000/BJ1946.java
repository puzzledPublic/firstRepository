package baekjoon.bj1000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//신입사원
public class BJ1946 {
	static class Score {
		int paper, interview;
		Score(int paper, int interview) {
			this.paper = paper;
			this.interview = interview;
		}
	}
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < T; i++) {
			int N = Integer.parseInt(br.readLine());
			int[] dp = new int[N + 1];
			List<Score> score = new ArrayList<>(N);
			StringTokenizer st;
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				score.add(new Score(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
			}
			
			score.sort((a, b) -> a.paper - b.paper); 
			
			int top = score.get(0).interview;
			int sum = 1;
			for(int j = 1; j < score.size(); j++) {
				if(score.get(j).interview < top) {
					top = score.get(j).interview;
					sum++;
				}
			}
			
			bw.write(sum + "\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
