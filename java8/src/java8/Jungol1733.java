package java8;

import java.util.Scanner;

//����
public class Jungol1733 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int[][] omokpan = new int[19][19];
		for (int i = 0; i < omokpan.length; i++) {
			for (int j = 0; j < omokpan[0].length; j++) {
				omokpan[i][j] = scanner.nextInt();
			}
		}

		findWinner(omokpan);

	}

	static void findWinner(int[][] omokpan) {
		/*
		 * int count = 0; for (int i = 0; i < omokpan.length; i++) { for (int j
		 * = 0; j < omokpan[0].length - 4; j++) { if (omokpan[i][j] != 0) { //
		 * ������ for (int k = j; k < j + 4 && k < omokpan.length; k++) { if
		 * (omokpan[i][k] == omokpan[i][k + 1]) { count++; } else { count = 0;
		 * break; } } if (count == 4) { System.out.println(omokpan[i][j]);
		 * System.out.println((i + 1) + " " + (j + 1)); return; } // �밢�� �� for
		 * (int k = j, h = i; k < j + 4 && j < omokpan.length && h > 0; k++,
		 * h--) { if (omokpan[h][k] == omokpan[h - 1][k + 1]) { count++; } else
		 * { count = 0; break; } } if (count == 4) {
		 * System.out.println(omokpan[i][j]); System.out.println((i + 1) + " " +
		 * (j + 1)); return; } if (i < omokpan.length - 4) { // �밢�� �Ʒ� for (int
		 * k = j, h = i; k < j + 4 && k < omokpan.length && h < omokpan.length;
		 * k++, h++) { if (omokpan[h][k] == omokpan[h + 1][k + 1]) { count++; }
		 * else { count = 0; break; } } if (count == 4) {
		 * System.out.println(omokpan[i][j]); System.out.println((i + 1) + " " +
		 * (j + 1)); return; } // �Ʒ� for (int k = i; k < i + 4 && k <
		 * omokpan.length; k++) { if (omokpan[k][j] == omokpan[k + 1][j]) {
		 * count++; } else { count = 0; break; } } if (count == 4) {
		 * System.out.println(omokpan[i][j]); System.out.println((i + 1) + " " +
		 * (j + 1)); return; } } } } } System.out.println("0");
		 */
		//�� ��ǥ�� ���� ������, �밢�� ��, �밢�� �Ʒ�, �Ʒ��� �˻��غ��� �ȴ�.
		//������ ���� 5���� ���� �˻��ϴµ� �־� �ٵ����� ũ�⸦ �Ѿ�ų� �� ������ ����̴�.
		//�� ���� 5�� �̻� ���� �� 5��° 6��°�� ���ϰ� �� 5��°�� ���� ��ǥ�� �� ���� �� �غ��� �Ѵ�
		boolean flag; // ���� �ϼ����� ǥ���ϴ� ����
		//�ٵ����� ���鼭
		for (int i = 0; i < omokpan.length; i++) {
			//�������� ������ ���� -4�� �� �� ��ŭ ���� (��ǥ�� 5��ŭ �پ��ų� �þ�Ƿ�)
			for (int j = 0; j < omokpan[0].length - 4; j++) {
				//
				if (omokpan[i][j] != 0) {
					flag = true;
					// ������ 
					//���� ��ǥ���� ���������� ���� 5���� ������ �˻�
					for (int k = j; k < j + 4 && k < omokpan.length; k++) {
						if (omokpan[i][k] != omokpan[i][k + 1]) {
							flag = false;
						}
					}
					//5��°�� 6��° ��(5�� �̻��� ������ �˻�)
					if (j + 5 < omokpan.length
							&& omokpan[i][j + 4] == omokpan[i][j + 5]) {
						flag = false;
					}
					//���� ��ǥ ���� ���� 5��° �� (�߰����� ���ϴ� ��찡 �����Ƿ� �� �� ���� �˻� �غ���)
					if(j>0 && omokpan[i][j + 4] == omokpan[i][j - 1]){
						flag = false;
					}
					//5����� ���
					if (flag) {
						System.out.println(omokpan[i][j]);
						System.out.println((i + 1) + " " + (j + 1));
						return;
					}
					// �밢�� ��(i�� 5 �̸��̶�� �밢�� ���� Ž���ϴµ� ������ �Ѿ��)
					if (i > 4) {
						flag = true;
						for (int k = j, h = i; k < j + 4 && j < omokpan.length
								&& h > 0; k++, h--) {
							if (omokpan[h][k] != omokpan[h - 1][k + 1]) {
								flag = false;
							}
						}
						if (i - 5 > 0
								&& j + 5 < omokpan.length
								&&  omokpan[i - 4][j + 4] == omokpan[i - 5][j + 5]) {
							flag = false;
						}
						if(i<omokpan.length-1 && j>0 && omokpan[i - 4][j + 4] == omokpan[i + 1][j - 1])
						{
							flag = false;
						}
						if (flag) {
							System.out.println(omokpan[i][j]);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
					//�Ʒ��� ���ϴ� ������ �ȳѵ��� ����
					if (i < omokpan.length - 4) {
						// �밢�� �Ʒ�
						flag = true;
						for (int k = j, h = i; k < j + 4 && k < omokpan.length
								&& h < omokpan.length; k++, h++) {
							if (omokpan[h][k] != omokpan[h + 1][k + 1]) {
								flag = false;
							}
						}
						if (i + 5 < omokpan.length
								&& j + 5 < omokpan.length
								&& omokpan[i + 4][j + 4] == omokpan[i + 5][j + 5]) {
							flag = false;
						}
						if(i > 0 && j >0 && omokpan[i + 4][j + 4] == omokpan[i - 1][j - 1]){
							flag =false;
						}
						if (flag) {
							System.out.println(omokpan[i][j]);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
						// �Ʒ�
						flag = true;
						for (int k = i; k < i + 4 && k < omokpan.length; k++) {
							if (omokpan[k][j] != omokpan[k + 1][j]) {
								flag = false;
							}
						}
						if (i + 5 < omokpan.length
								&& omokpan[i + 4][j] == omokpan[i + 5][j]) {
							flag = false;
						}
						if(i>0 &&omokpan[i + 4][j] == omokpan[i - 1][j]){
							flag =false;
						}
						if (flag) {
							System.out.println(omokpan[i][j]);
							System.out.println((i + 1) + " " + (j + 1));
							return;
						}
					}
				}
			}
		}
		//���� �Ǵ°� ���� ��� 0 ���
		System.out.println("0");
	}
}
