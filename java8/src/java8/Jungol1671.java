package java8;

import java.util.Scanner;

//������(��)
//����, ���� ���̰� ���� 100�� ���簢���� ��ȭ���� �ִ�.
//����, ���� ���̰� ���� 10�� ������ ���̵��� ��ȭ���� �����Ͽ� �ٿ������� �����̰� ���� ������ �ѷ��� ���϶�
//�Է� ������ ���� N ( N <= 100)�� N���� �ڿ���(x , y) ��ǥ
public class Jungol1671 {
	static boolean[][] dohwaji = new boolean[102][102];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, x, y, count = 0;
		//������ �� �Է�
		n = scanner.nextInt();
		//������ ��ǥ�� �Է� �޾� �ٷ� ��ȭ���� �׸���(true�� ǥ��)
		for (int i = 0; i < n; i++) {
			x = scanner.nextInt();
			y = scanner.nextInt();
			for (int j = x; j < x + 10; j++) {
				for (int k = y; k < y + 10; k++) {
					dohwaji[j][k] = true;
				}
			}
		}
		//��ȭ�� ��ü Ž��
		for (int i = 1; i < dohwaji.length - 1; i++) {
			for (int j = 1; j < dohwaji[0].length - 1; j++) {
				//������ġ�� true(������)�̶��
				if (dohwaji[i][j] == true) {
					//�����¿츦 ���Ǹ� false(���)�̶�� �׵θ��� ���� �ѷ� ���� ����
					//��
					if (dohwaji[i - 1][j] == false) {
						count++;
					}
					//��
					if (dohwaji[i + 1][j] == false) {
						count++;
					}
					//��
					if (dohwaji[i][j + 1] == false) {
						count++;
					}
					//��
					if (dohwaji[i][j - 1] == false) {
						count++;
					}
					
				}
			}
		}
		System.out.println(count);
	}
}
