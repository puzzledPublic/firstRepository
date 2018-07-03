package baekjoon;

import java.util.Scanner;
//동전 1
public class BJ2293 {
	static int N, K;
	static int[] coins, DT;
	static int ans = 0;
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		N = input.nextInt();
		K = input.nextInt();
		coins = new int[N];
		DT = new int[K + 1];
		for(int i = 0; i < N; i++) {
			coins[i] = input.nextInt();
		}
		solve(0);
		System.out.println(ans);
	}
	
	static void solve(int n) {
		if(n == K) {
			ans++;
		}
		for(int i = 0; i < N; i++) {
			if(n + coins[i] <= K) {
				solve(n + coins[i]);
			}
		}
	}
}
