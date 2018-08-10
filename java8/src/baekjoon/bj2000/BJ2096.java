package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.function.IntBinaryOperator;

//내려가기
public class BJ2096 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		int[][] dp = new int[N][3];
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i][2] = Integer.parseInt(st.nextToken());
		}
		for(int i = 0; i < 3; i++) {
			dp[0][i] = arr[0][i];
		}
		
		solve(arr, dp, (a, b) -> a < b ? b : a);
		solve(arr, dp, (a, b) -> a < b ? a : b);
		
		br.close();
	}
	static void solve(int[][] arr, int[][] dp, IntBinaryOperator ibo) {
		int len = arr.length;
		for(int i = 1; i < len; i++) {
			for(int j = 0; j < 3; j++) {
				if(j == 0) {
					dp[i][j] = ibo.applyAsInt(dp[i - 1][0], dp[i - 1][1]) + arr[i][j];
				}else if(j == 1) {
					dp[i][j] = ibo.applyAsInt(dp[i - 1][0], ibo.applyAsInt(dp[i - 1][1], dp[i - 1][2])) + arr[i][j];
				}else {
					dp[i][j] = ibo.applyAsInt(dp[i - 1][1], dp[i - 1][2]) + arr[i][j];
				}
			}
		}
		System.out.println(ibo.applyAsInt(dp[len - 1][0], ibo.applyAsInt(dp[len - 1][1], dp[len - 1][2])));
	}
}
