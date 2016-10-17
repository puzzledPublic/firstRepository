package java8;

import java.util.Scanner;

//���װ�� ��� (n���� ���� �ٸ� ���� �� r���� ���Ҹ� �������� ��󳻴� ����� ��)
public class BinomialCoefficient {
	static int[][] cache = new int[30][30];
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int n, r;
		n = scanner.nextInt();
		r = scanner.nextInt();
		for(int i = 0 ; i < cache.length ; i++){
			for(int j = 0 ; j < cache[0].length; j++){
				cache[i][j] = -1;
			}
		}
		System.out.println("���: " + bino(n,r));
		
	}
	//(n, r) = (n-1, r-1) + (n-1, r)�� ��ȭ���� ����
	static int bino(int n, int r){
		if(r == 0 || n == r){
			return 1;
		}
		if(cache[n][r] != -1){
			return cache[n][r];
		}
		return cache[n][r] = bino(n-1, r-1) + bino(n-1, r);
	}
}
