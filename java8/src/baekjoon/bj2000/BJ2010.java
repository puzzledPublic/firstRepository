package baekjoon.bj2000;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//플래그
public class BJ2010 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine()), sum = 0;
		for(int i = 0; i < N; i++) {
			sum += Integer.parseInt(br.readLine());
		}
		System.out.println(sum - N + 1);
	}
}
