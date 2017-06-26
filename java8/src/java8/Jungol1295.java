package java8;

import java.util.Scanner;

//����Ž��
//���������� ������� ���ĵǾ� �ִ� N���� �����Ϳ��� Ư���� ���ڰ� �� ��° ��ġ������ ����϶�
//ù �ٿ� N�� �־�����. N�� ���ĵǾ� �־����� �������� ���̴�.(1��N��50,000)
//��° �ٿ��� N���� ���� �ٸ� ���� ���ĵǾ� �־�����. �� ���� ���� �ϳ��� �и��Ǿ� �־�����.
//��° �ٿ��� �����Ϳ��� ã�ƾ��� Ư���� ���� ���� T�� �־�����. ��, T�� 3�̸� 3���� ���� ���ĵ� �����Ϳ��� ã�ƾ� �Ѵ�.(1��T��10,000)
//��° �ٿ��� T���� ���� ���� �ϳ��� �и��Ǿ� �־�����.
//ã�ƾ��� ���� ���ĵǾ� �־��� �������� ���߿��� �տ������� �� ��°�� �ִ��� �� ��ġ�� ����Ѵ�. ù ��° ��ġ�� 1�̴�. ����, ã������ ���� �־����� �����Ϳ� �������� �ʴ´ٸ�, 0�� ����Ѵ�.
public class Jungol1295 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, t;

		n = scanner.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < n; i++) {
			arr[i] = scanner.nextInt();
		}

		t = scanner.nextInt();
		int[] numbers = new int[t];
		for (int i = 0; i < t; i++) {
			numbers[i] = scanner.nextInt();
		}
		for (int i = 0; i < t; i++) {
			binarySearch2(arr, numbers[i]);
		}
	}
/*
	static void binarySearch(int[] arr, int number) {
		int low = 0;
		int high = arr.length;
		int index = (arr.length - 1) / 2;
		int count = 0;
		while (arr[index] != number ) {
			if (number < arr[index]) {
				high = index;
				index = (low + index) / 2;
			} else {
				low = index;
				index = (index + high) / 2;
			}
			count++;
			if(count > arr.length / 2 + 1){
				break;
			}
		}
		if (count > arr.length / 2 + 1) {
			System.out.println(0);
		} else {
			System.out.println(index + 1);
		}
	}*/
	static void binarySearch2(int[] arr, int number){
		int low = 0;
		int high = arr.length;
		int index = -1;
		while(low<=high){
			index = (low + high)/2;
			if(arr[index] == number){
				break;
			}
			else if(arr[index] > number){
				high = index - 1;
				
			}else{
				low = index + 1;
			}
		}
		if(low>high){
			System.out.println(0);
		}else{
			System.out.println(index + 1);
		}
	}
}
