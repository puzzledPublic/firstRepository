package java8;

import java.util.Scanner;

//��������
//�� ������ ���Ҹ� �˻��Ͽ� �ڸ��� �ٲٴ� ������ �ݺ��ϸ� �����ϴ� ���
//1. ù��° ���� �ι�° ���� ���Ͽ� ù��° ���� ũ�� �ڸ��� �ٲ۴�.
//2. �ι�° ���� ����° ���� ���Ͽ� �ι�° ���� ũ�� �ڸ��� �ٲ۴�.
//3. ���� ���� �ݺ��Ͽ� N-1��° ���� N��° ���� ���Ͽ� N-1��° ���� ũ�� �ڸ��� �ٲ۴�. 
//   �� �ܰ谡 ������ N��°�� ���� ū ���� �ڸ��ϰ� �ȴ�. (�Ѵܰ�Ϸ�)
//4. N��°�� �����ϰ� 1~3�� �ݺ��ϸ� N-1��°�� �� ��°�� ū���� �ڸ��Ѵ�. (2�ܰ� �Ϸ�) 
//5. ���Ͱ��� �۾��� N-1�� �ݺ��ϸ� ��� �����Ͱ� ������� ���ĵȴ�.
public class Jungol1157 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, temp;
		n = scanner.nextInt();
		int[] arr = new int[n];
		for(int i = 0 ; i < n; i++){
			arr[i]=scanner.nextInt();
		}
		
		for(int i = n-1; i > 0; i--){
			for(int j = 0; j < i; j++){
				if(arr[j]>arr[j+1]){
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}

			}
			for(int j = 0; j < n; j++){
				System.out.print(arr[j]+" ");
			}System.out.println();
		}
	}
}
