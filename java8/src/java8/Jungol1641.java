package java8;

import java.util.Scanner;

//���� �ﰢ�� ���ϱ�
public class Jungol1641 {

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		int n;// �ﰢ�� ���� 100 ���� Ȧ��
		int m; // �ﰢ�� ���� 1~3 ����
		n = scanner.nextInt();
		m = scanner.nextInt();
		if (n % 2 == 0 || n > 100 || m < 1 || m > 3) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}
		switch (m) {
		case 1:
			option1(n);
			break;
		case 2:
			option2(n);
			break;
		case 3:
			option3(n);
			break;
		}

	}

	public static void option1(int n) {
		int k = 1;
		int temp = 1;
		for (int i = 0; i < n; i++) {
			if (i % 2 == 0) {
				k = temp;
				for (int j = 0; j < i + 1; j++) {
					System.out.print(k++ + " ");
				}
				temp = k;
			} else {
				k = temp + i;
				temp = k + 1;
				for (int j = 0; j < i + 1; j++) {
					System.out.print(k-- + " ");
				}
			}
			System.out.println();
		}
	}

	public static void option2(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < i * 2; j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < n * 2 - (i * 2) - 1; j++) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
	}

	public static void option3(int n) {
		int k = 1;
		for (int i = 1; i <= n / 2 + 1; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(k++ +" ");
			}
			k=1;
			System.out.println();
		}
		for (int i = 1; i <= n / 2; i++) {
			for (int j = n / 2 - i + 1; j >= 1; j--) {
				System.out.print(k++ +" ");
			}
			k=1;
			System.out.println();
		}
	}
}
