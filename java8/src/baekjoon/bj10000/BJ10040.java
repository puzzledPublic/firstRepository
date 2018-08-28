package baekjoon.bj10000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

//투표
public class BJ10040 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken()), M = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] vote = new int[N];
		for(int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for(int i = 0; i < M; i++) {
			int cost = Integer.parseInt(br.readLine());
			for(int j = 0; j < N; j++) {
				if(arr[j] <= cost) {
					vote[j]++;
					break;
				}
			}
		}
		int max = 0, result = 0;
		for(int i = 0; i < N; i++) {
			if(max < vote[i]) {
				max = vote[i];
				result = i + 1;
			}
		}
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
