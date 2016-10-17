package java8;

import java.util.Arrays;
import java.util.Scanner;

//������ 8.14
//�������̳�
//n���� ���簢������ ������ ���� ���� �������̳��� ���� ����϶�
// 1 <= n <= 100
//������ 10,000,000�̻��� ��� 10,000,000���� ���� �������� ���
public class Polyomino {
	final static int MOD = 10*1000*1000;
	static int[][] cache = new int[101][101];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		for (int i = 0; i < cache.length; i++) {
			Arrays.fill(cache[i], -1);
		}
		int result = 0;
		for(int i = 1 ; i <= n; i++){
			result += poly(n,i);
		}
		System.out.println(result);
	}

	//ù���� first���� �̷���� n���� ���簢������ ���� �� �ִ� �������̳� ������ ���� 
	static int poly(int n, int first) {
		if(n == first){
			return 1;
		}
		if(cache[n][first] != -1){
			return cache[n][first];
		}
		cache[n][first] = 0;
		for(int second = 1; second <= n-first; second++){
			int add = second + first - 1;
			add *= poly(n-first, second);
			add %= MOD;
			cache[n][first] += add;
			cache[n][first] %= MOD;
		}
		return cache[n][first];
	}
}
