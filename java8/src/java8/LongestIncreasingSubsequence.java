package java8;

import java.util.Arrays;

//최대 증가 부분 수열 길이 구하기 (문제해결전략 동적계획법)
public class LongestIncreasingSubsequence {
	static int cache[] = new int[100];
	static int cache2[][] = new int[100][100];
	// 수열
	static int s[] = { 1,2,3};
	static int s2[] = { 10, 20, 30 };

	public static void main(String args[]) {
		// -1로 캐쉬 초기화
		Arrays.fill(cache, -1);
		for (int i = 0; i < cache2.length; i++) {
			Arrays.fill(cache2[i], -1);
		}/*
		 * int maxLength = 0; for (int begin = 0; begin < s.length; begin++) {
		 * maxLength = Math.max(maxLength, lis(begin)); }
		 * System.out.println(maxLength);
		 */
		int maxLength = 0;
		for (int i = 0; i < s.length; i++) {
			for (int j = 0; j < s2.length; j++) {
				maxLength = Math.max(maxLength, jlis(i, j));
			}
		}
		System.out.println(maxLength);
	}

	// 최대 증가 부분 수열 길이
	static int lis(int start) {
		if (cache[start] != -1) {
			return cache[start];
		}

		int ret = 1;

		for (int next = start + 1; next < s.length; next++) {
			if (s[start] < s[next]) {
				ret = Math.max(ret, lis(next) + 1);
			}
		}
		return ret;
	}

	// 두 수열의 합친 최대 증가 부분 수열 길이
	static int jlis(int indexA, int indexB) {
		if (cache2[indexA][indexB] != -1) {
			return cache2[indexA][indexB];
		}
		// 기본적으로 길이는 2 이상
		int ret = 2;

		int a = s[indexA];
		int b = s2[indexB];
		int minElement = Math.min(a, b);
		if (s[indexA] != s2[indexB]) {
			for (int next = indexA + 1; next < s.length; next++) {
				if (minElement < s[next]) {
					ret = Math.max(ret, jlis(next, indexB) + 1);
				}
			}
			for (int next = indexB + 1; next < s2.length; next++) {
				if (minElement < s2[next]) {
					ret = Math.max(ret, jlis(indexA, next) + 1);
				}
			}
		}
		return ret;

	}
}
