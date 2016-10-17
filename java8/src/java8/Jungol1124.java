package java8;

import java.util.Scanner;

//������(��)
//����, ���� ���̰� ���� 100�� ���簢���� ��ȭ���� �ִ�.
//����, ���� ���̰� ���� 10�� ������ ���̵��� ��ȭ���� �����Ͽ� �ٿ������� ��ȭ������ ���� �� �ִ� ������ ���簢���� �ִ� ���̸� ���϶�
//���簢���� ��ȭ���� �����ؾ� �Ѵ�
//���簢���� ���簢���� �����Ѵ�.
//�Է� ������ �� N( N <= 100), ������ �� ��ŭ�� �������� ��ġ(x, y)
public class Jungol1124 {
	static int[][] dohwaji = new int[102][102];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, x, y, count = 0;
		n = scanner.nextInt();
		for (int i = 0; i < n; i++) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					dohwaji[j][k] = 1;
				}
			}
		}

		for (int i = 1; i < dohwaji.length; i++) {
			for (int j = 1; j < dohwaji[0].length; j++) {
				if (dohwaji[i][j] == 1) {
					dohwaji[i][j] += dohwaji[i - 1][j];
				}
			}
		}
		int max = 0;
		for (int i = 1; i < dohwaji.length; i++) {
			for (int j = 1; j < dohwaji[0].length; j++) {
				int length = 100;
				int width = 1;
				for(int k = j; k >0 &&dohwaji[i][k]>0;--k, width++){
					if(dohwaji[i][k]< length){
						length =dohwaji[i][k];
						
					}
					if(max < length*width){
						max = length*width;
					}
				}
				
			}
		}/*for (int i = 1; i < dohwaji.length/2; i++) {
			for (int j = 1; j < dohwaji[0].length/2; j++) {
				System.out.print((dohwaji[i][j]<10?" "+dohwaji[i][j]:dohwaji[i][j])+ " ");
			}
			System.out.println();
		}*/
		System.out.println(max);

	}
}
