package java8;

import java.util.Scanner;

//��������
//1. �־��� ���� �߿� �ּҰ��� ã�´�.
//2. ã�� �ּҰ��� �� ���� ���� �ڸ��� �ٲ۴�.
//3. �� ���� ���� �� ������ ������ ���� ������� ��ü ����-1�� �ݺ� �����Ѵ�.
//n���� �־��� ������ ���� ���� ������� �����Ѵ�.
//������ �־����� ���������� ������ �� �ܰ辿 ����Ѵ�.
//�Է�: ������ ���� N(4<= N <=100), N���� ������(0 <= <= 100)
public class Jungol1146 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, min = 1001, k = 0, least, temp;
		n = scanner.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}
		for(int i = 0 ; i < n - 1; i++){
			least = i;
			for(int j = i+1; j < n; j++){
				if(arr[j] < arr[least]) {
					least = j;
				}
			}
			temp = arr[i];
			arr[i] = arr[least];
			arr[least] = temp;
			for (int j = 0; j < n; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
		/*
		for (int i = 0; i < n - 1; i++) {
			for (int j = i; j < n; j++) {
				if (min > arr[j]) {
					min = arr[j];
					k = j;
				}
			}
			arr[k] = arr[i];
			arr[i] = min;
			min = 1001;
			for (int j = 0; j < n; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}*/
	}
}
