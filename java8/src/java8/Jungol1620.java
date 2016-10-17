package java8;

import java.util.Scanner;
//��ȭ��ȣ ���� ��ȣ
//��ȭ��ȣ�� ���� 2���� �־����� (��ȭ��ȣ���ڿ� <= 100, 1<= ������ ���� <= 9, ��ġ ��ȣ)
//ù��° ���ڴ� �ش� ��ȭ��ȣ ���ڵ鿡 ���� ���ڰ� 
//�ι�° ���ڴ� ù��° ���ڸ� ���� ��ȭ��ȣ�� ��ġ�� ��Ÿ����
//��ȭ��ȣ�� '-'���� ���еǸ� 0~9���� ���ڴ�
//���ϴ� ���ڰ� 9�� ���� ��� 1�� �ڸ� ���� ���Ѵ�.
//���ڴ� �� 4�ڸ����� �ϸ� 4�ڸ��� �ȵ� ��� ���ʺ��� 0�� ä�� �ִ´�.
//ó�������� �������� �ʴ´ٸ� "INPUT ERROR"�� ����Ѵ�.

public class Jungol1620 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String phoneNumber;
		int plus, index;
		//�Է�
		phoneNumber = scanner.next();
		plus = scanner.nextInt();
		index = scanner.nextInt();
		//�������� '-'�θ� ������
		if(phoneNumber.endsWith("-")){
			//���� '0'�� �ٿ���
			phoneNumber =phoneNumber.concat("0");
		}
		// '-'�� �����Ͽ� String �迭�� ����
		String[] numbers = phoneNumber.split("-");
		lockNumber(numbers, plus, index);
	}

	static void lockNumber(String[] numbers, int plus, int index) {
		//����� ���� 4�ڸ� �迭
		char[] result = new char[4];
		//��ȣ�� �߿� 5�ڸ��� �Ѵ� ���� �ִٸ� �Է� ����
		for(int i = 0 ; i < numbers.length;i++){
			if(numbers[i].length()>4){
				System.out.println("INPUT ERROR!");
				System.exit(0);
			}
		}
		//��ġ�� ��ȭ��ȣ ���̺��� �� ū ��� �Է� ����
		if (numbers.length < index) {
			System.out.println("INPUT ERROR!");
		} else {
			//��ȣ ���� ����
			int len = numbers[index - 1].length()-1;
			//��� �迭�� �Ųٷ� ����
			for (int i = result.length-1; i >= 0; i--) {
				//��ȣ ���� ���̰� �ٴڳ�����
				if (len < 0) {
					//0���� ġ�� plus�� ������
					result[i] = (char)(plus+48);
				}
				//�ƴ϶��
				else {
					//���� ���ڿ� plus�� ����
					int temp = ((int) (numbers[index - 1].charAt(len--)) + plus);
					//10�� �Ѿ�� 1�� �ڸ� ���� �ִ´�
					result[i] = temp>57? (char)(temp-10):(char)temp;
				}
			}
			//��� �迭 ���
			for (int i = 0; i < result.length; i++) {
				System.out.print(result[i]);
			}
		}
	}
}
