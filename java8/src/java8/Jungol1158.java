package java8;

import java.util.Scanner;

//��������
//��� ��Ҹ� �տ������� ���ʴ�� �̹� ���ĵ� �迭 �κа� ���Ͽ�, �ڽ��� ��ġ�� ã�� �����ϴ� ���
//ù�ٿ� ������ ���� N(4��N��100)�� �־�����.
//�� ��° �ٿ� N���� 0�̻� 100������ ������ �־�����.
public class Jungol1158 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		int n, temp, index;
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
			}
			arr[index+1] = temp;
			for (int j = 0; j < n; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}
		/*
		for(int i = 1 ; i < n; i++){
			index = i;
			for(int j = i-1; j >= 0; j--){
				if(arr[index]<arr[j]){
					temp = arr[index];
					arr[index] = arr[j];
					arr[j] = temp;
					index--;
				}else{
					break;
				}
			}
			for (int j = 0; j < n; j++) {
				System.out.print(arr[j] + " ");
			}
			System.out.println();
		}*/
	
	}
}
