package java8;

import java.util.Scanner;

//���ھ߱�
//1~9�ڸ��� 3�ڸ��� ���ھ߱��̴�.
//��� 3�ڸ� ���ڵ�� �׿� ���� ��Ʈ����ũ, ���� ���ο� ���� ����� �Է����� �־�����.
//�̶� ���ɼ� �ִ� 3�ڸ����� ������ ���϶�
//�Է�: ������ ���� N ( 1 <= N <= 100), ���� N���� �ٿ� ������ 3�ڸ����� �׿� ���� ��Ʈ����ũ, ���� ������ ��Ÿ���� ����

public class Jungol1761 {
	static boolean[] baseballNumbers = new boolean[1000];

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		// ������ 3�ڸ����� ���� �迭
		int[] number = new int[n];
		// ������ ����� ���� �迭
		int[][] result = new int[n][2];
		// �Է�
		for (int i = 0; i < n; i++) {
			number[i] = scanner.nextInt();
			result[i][0] = scanner.nextInt();
			result[i][1] = scanner.nextInt();
		}
		// ������ 3�ڸ����� �迭�� Ž���ϸ�
		for (int i = 0; i < n; i++) {
			// ��� 3�ڸ����� Ž��
			for (int j = 111; j < baseballNumbers.length; j++) {
				// ó�� ������ ���� ������ 3�ڸ� ���ڵ��� üũ�Ѵ�
				if (i == 0) {
					if (checkNumber(j, number[i], result[i][0], result[i][1])) {
						baseballNumbers[j] = true;
					}
				}
				// ���� �������ʹ� üũ�� �͵鿡���� �ɷ�����
				else {
					if (baseballNumbers[j] == true
							&& !checkNumber(j, number[i], result[i][0],
									result[i][1])) {
						baseballNumbers[j] = false;
					}
				}
			}
		}
		int count = 0;
		for (int i = 111; i < baseballNumbers.length; i++) {
			if (baseballNumbers[i] == true) {
				count++;
			}
		}
		System.out.println(count);

	}
	//��Ʈ����ũ ���� ������ �Ǻ��ϴ� �Լ�
	static boolean checkNumber(int checkNumber, int number, int s, int b) {
		int[] cN = new int[3];
		int[] iN = new int[3];

		for (int i = 2; i >= 0; i--) {
			cN[i] = checkNumber % 10;
			checkNumber /= 10;
			iN[i] = number % 10;
			number /= 10;
		}
		for (int i = 0; i < 2; i++) {
			for (int j = i + 1; j < 3; j++) {
				if (cN[j] == 0 || cN[i] == cN[j]) {
					return false;
				}
			}
		}
		int strike = 0;
		int ball = 0;
		for (int i = 0; i < 3; i++) {
			if (cN[i] == iN[i]) {
				strike++;
			} else {
				for (int j = 0; j < 3; j++) {
					if (cN[j] == iN[i]) {
						ball++;
					}
				}
			}
		}
		if (strike == s && ball == b) {
			// System.out.println(cN[0]+""+cN[1]+""+cN[2]+" "+iN[0]+""+iN[1]+""+iN[2]
			// +" "+s+" "+b);
			return true;
		}
		return false;

	}
}
