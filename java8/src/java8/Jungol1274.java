package java8;

import java.util.Scanner;

//2������ 10������...
//2������ �Է¹޾� 10������ �ٲ��
//�Է¹޴� 2������ 8��Ʈ�� �����Ǹ� �ֻ��� ��Ʈ�� ��ȣ��Ʈ
//0�̸� ��� 1�̸� �����̸� ������ 2�� ����
public class Jungol1274 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		String bi;
		bi = scanner.nextLine();
		change(bi.toCharArray());
	}

	static void change(char[] bi) {
		int result;
		//����϶�
		if (bi[0] == '0') {
			//�״�� �������� ����
			result = biToDecimal(bi);
		}
		//�����϶�
		else {
			//1�� ������ �ٲ�
			for (int i = 1; i < bi.length; i++) {
				if (bi[i] == '0') {
					bi[i] = '1';
				} else {
					bi[i] = '0';
				}
			}
			//��Ʈ�� 1�� ����
			if (bi[bi.length - 1] == '0') {
				bi[bi.length - 1] = '1';
			} else {
				bi[bi.length-1] = '0';
				for (int j = bi.length - 2; j > 0; j--) {
					if (bi[j] == '0') {
						bi[j] = '1';
						break;
					}
					else{
						bi[j] = '0';
					}
				}
			}
			//�������� ��ȯ
			result = biToDecimal(bi);
			//��ȣ ����
			result *=-1;
		}
		//��� ���
		System.out.println(result);
	}
	//2���� -> 10���� ��ȯ �Լ�
	static int biToDecimal(char[] bi){
		int ten = 0;
		for (int i = 1; i < bi.length; i++) {
			ten = ten * 2 + (bi[i] - '0');
		}
		return ten;
	}
}
