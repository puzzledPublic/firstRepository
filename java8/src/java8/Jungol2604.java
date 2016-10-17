package java8;

import java.util.Scanner;

//�׸�
// '(' or ')'�θ� ������ ���ڿ��� �־�����
// '(', ')' �ϳ��� 10cm�̰� '()' => 20cm, '((' ���� �������� ������������ +5cm�� �ȴ�(15cm)
//���� �׸��� �� ���̸� ���϶� (���ڿ� ����: 3 <= text <= 50) 
public class Jungol2604 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String text;
		//�Է�
		text = scanner.nextLine();
		bowlStack(text.toCharArray());
	}
	static void bowlStack(char[] bowl){
		//ó�� �׸����� ���� 
		int bowlLength = 10;
		//�ι�° �׸����� ������ �׸�����
		for(int i = 1 ; i < bowl.length; i++){
			//�� �׸��� ���ٸ� +5cm
			if(bowl[i-1]==bowl[i]){
				bowlLength+=5;
			}
			//�ٸ��ٸ� +10cm
			else{
				bowlLength+=10;
			}
		}
		//���
		System.out.println(bowlLength);
	}
}
