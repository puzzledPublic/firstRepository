package baekjoon.bj7000;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

//��
public class BJ7579 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] memory = new int[N];
		int[] cost = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			memory[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		
		long[][] dp = new long[N][N * 100 + 1];	//i��° ���� ����� ���� ��Ȱ�� ����� j�϶� ������ �� �ִ� �ִ� ����Ʈ ��
		
		dp[0][cost[0]] = memory[0];
		
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < N * 100 + 1; j++) {
				if(j - cost[i] >= 0) {
					dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - cost[i]] + memory[i]);	//���� i�� ��Ȱ�� �ϰų�
				}
				dp[i][j] = Math.max(dp[i][j], dp[i - 1][j]);	//��Ȱ�� ���� �ʰų�
			}
		}
		
		int result = 0;
		for(int i = 0; i < N * 100 + 1; i++) {
			if(dp[N - 1][i] >= M) {	//���ʷ� M���� Ŭ �� ����� �ּ�
				result = i;
				break;
			}
		}
		
		bw.write(result + "\n");
		
		bw.flush();
		bw.close();
		br.close();
	}
}
