package java8;

import java.util.Scanner;

//�������
//A(000000),B(001111),C(010011),D(011100),E(100110),F(101001),G(110101),H(111010)�� ��ȣ���̴�
//�Է�- ���ڰ���(textLength <=10), ���ڿ�( 0 �Ǵ� 1�� �̷���� (textLength * 6)���� ���ڿ�)�� �־��� ��
//�ش� ���ڷ� ��ȣȭ�� �϶�(���ڰ� 2�� �̻� �ٸ��ٸ� �ش� ��ġ�� ���, 1���� �ٸ��ٸ� �״�� ���ڸ� ���)
public class Jungol1239 {
	//�ش� ��ȣ�� ����
	static char[][] cryptography = { { '0', '0', '0', '0', '0', '0' },
			{ '0', '0', '1', '1', '1', '1' }, { '0', '1', '0', '0', '1', '1' },
			{ '0', '1', '1', '1', '0', '0' }, { '1', '0', '0', '1', '1', '0' },
			{ '1', '0', '1', '0', '0', '1' }, { '1', '1', '0', '1', '0', '1' },
			{ '1', '1', '1', '0', '1', '0' }, };

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int textLength;
		String text;
		//�Է�
		textLength = scanner.nextInt();
		text = scanner.next();
		//����
		decryptSecretMail(text.toCharArray());

	}

	static void decryptSecretMail(char[] text) {
		
		int min = 9999;
		//��ȣȭ�� ���ڸ� ���� �迭
		char[] decryptedText = new char[text.length/6];
		//���� ���ڰ� ��� �ٸ��� ������ ���� 
		int count = 0;
		//��ȣ���� �������� �ٸ� ���ڰ� 2�� �̻��ΰ�� ����
		int failCount = 0;
		//��� ���ڸ� ����(6�� ����)
		for (int i = 0; i < text.length / 6; i++) {
			//��ȣ���� ����
			for (int j = 0; j < cryptography.length; j++) {
				count = 0;
				for (int k = 0; k < cryptography[0].length; k++) {
					//���� �ٸ� ���ڰ� �ִ� ���
					if (text[i * 6 + k] != cryptography[j][k]) {
						count++; //����
					}
				}
				//�ٸ� ������ ������ 0, 1 �̸�
				if (count == 0 || count == 1) {
					//���ڸ� �ص� �� ���� ���ڷ� 
					decryptedText[i] = (char)(j+65);
					break;
				}
				//2 �̻��̸� failCount ����
				else{
					failCount++;
				}
				
			}
			//System.out.println(failCount);
			//���� failCount�� 8�ΰ��(��� ��ȣ���� Ž���ص� ��Ī�Ǵ� ���ڰ� ���� ���)
			if(failCount == 8){
				//�ش� ��ġ�� ���� �� ��ü for�� ����
				min = i+1;
				break;
			}
			failCount=0;
		}
		//���
		if(failCount == 8){
			System.out.println(min);
		}
		else{
			for(int i = 0 ; i < decryptedText.length; i++){
				System.out.print(decryptedText[i]);
			}
		}
	}
}
