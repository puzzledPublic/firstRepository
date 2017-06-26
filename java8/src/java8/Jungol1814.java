package java8;

import java.util.Scanner;

//�������� Ƚ�� ����
//������ ���� ���� ���� ���� �̷���� ���� A�� ���������� �ϰ��� �Ѵ�.
//���� �迭 A�� 20, 40, 30, 10 �� �� ��� ������ ���� ���������� �̷������.
//i = 1 �� �� 20, 40, 30, 10 �̵��� : 0
//i = 2 �� �� 20, 40, 30, 10 �̵��� : 0
//i = 3 �� �� 20, 30, 40, 10 �̵��� : 1 (40�� �����̰� 30�� ��)
//i = 4 �� �� 10, 20, 30, 40 �̵��� : 3 (20, 30, 40 �� �����̰� 10�� ��)
//�� 4���� �о�⸦ ���Ͽ� ���������� �Ϸ�ȴ�.
//������ ���� A�� �־��� ���, ������ ���ڰ� �󸶳� �̵��ϴ��� ����ϴ� ���α׷��� �ۼ��Ͻÿ�.
//ó�� �ٿ��� ������ ���� N(1��N��50)�� �Էµȴ�.
//���� �ٿ��� N���� -1000 �̻� 1000 ������ ������ �Էµȴ�. �� ������ ���� �ٸ��ٰ� �����Ѵ�.
public class Jungol1814 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, temp, index, count = 0;
		n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i] = scanner.nextInt();
		}
		for(int i = 1; i < n; i++){
			temp = arr[i];
			index = i - 1;
			while(index>=0 && arr[index] > temp){
				arr[index+1] = arr[index];
				index--;
				count++;
			}
			arr[index+1] = temp;
		}
		System.out.println(count);
	}
}
