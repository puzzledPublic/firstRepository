package java8;

import java.util.Scanner;

//�Ҽ� ���ϱ�
//������ M���� ���� M�� ���� ����� �Ҽ��� ���϶�(���̰� ���� ���� �������� ���� �� ���� ��� ���)
public class Jungol1901 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		// ó���ؾ� �� ���� ����(n<=100)
		int n;
		n = scanner.nextInt();
		// ó���� ���� ������ŭ �迭 ����
		int arr[] = new int[n];
		//�Է�
		for (int i = 0; i < arr.length; i++) {
			arr[i] = scanner.nextInt();
		}
		//���
		printPNumber(arr);
	}

	static void printPNumber(int[] arr) {
		//���� ���ڷκ��� ����
		int defer = 0;
		//������ ���ڰ� �Ҽ����� �ƴ��� �����ϴ� ����
		boolean down, up;
		//�Է� ���ڵ��� ����
		for(int i = 0 ; i < arr.length;i++){
			//���� �ڱ��ڽ��� �Ҽ���� �״�� ����ϰ� ���� ���ڷ�
			if(isPrimeNumber(arr[i])){
				System.out.println(arr[i]);
				continue;
			}
			//���ڸ� ���� ��, �Ʒ��� �����̸�
			while(arr[i]-defer>2){
				//�Ʒ� ���ڰ� �Ҽ����� �ƴ���
				down = isPrimeNumber(arr[i]-defer);
				//�� ���ڰ� �Ҽ����� �ƴ���
				up = isPrimeNumber(arr[i]+defer);
				//�Ѵ� �Ҽ����
				if(down && up){
					//���� �� ���� ����ϰ� ���� Ż��
					System.out.print(arr[i]-defer+" ");
					System.out.println(arr[i]+defer);
					break;
				}
				//�Ʒ� ���ڸ� �Ҽ���� ����ϰ� ���� Ż��
				else if(down){
					System.out.println(arr[i]-defer);
					break;
				}
				//�� ���ڸ� �Ҽ���� ����ϰ� ���� Ż��
				else if(up){
					System.out.println(arr[i]+defer);
					break;
				}
				//������ ����
				defer++;
			}
			//���� ���ڸ� ���� ���� �ʱ�ȭ
			defer=0;
		}
	}
	//�Ҽ����� �ƴ��� �Ǻ��ϴ� �Լ�
	static boolean isPrimeNumber(int number) {
		for (int i = 2; i * i <= number; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
