package baekjoon.bj11000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.StringTokenizer;

//파일 합치기	//not yet
public class BJ11066 {
	static int[][] DP = new int[501][501];	//파일을 i~j까지 합치는데 최소 비용
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		for(int i = 0; i < T; i++) {
			solve(Integer.parseInt(br.readLine()), br.readLine(), bw);
		}
		
//		bw.flush();
		bw.close();
		br.close();
	}
	
	static void solve(int n, String s, Writer w) throws IOException {
		StringTokenizer st = new StringTokenizer(s, " ");
		int[] files = new int[n + 1];
		int[] sum = new int[n + 1];
		for(int i = 1; i <= n; i++) {
			files[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i - 1] + files[i];
		}
		
		for(int i = 1; i <= n; i++) {
			for(int j = 2; j <= n; j++) {
				if(i == j) {
					DP[i][j] = 0;
				}
				int min = 987654321;
//				for(int k = 0; k < j - i;)
			}
		}
		
	}
}
