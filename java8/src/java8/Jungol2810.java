package java8;

import java.util.Scanner;

//Ÿ�� ��ü (���簢���� Ÿ�Ϸ� �ٴ��� �� ä��µ� �ּ� Ÿ�� ������ ���ϴ� ����)
//(�ٴ��� ���� ���� ���̰� �־����� 1<= ����,���� <=1000000)
public class Jungol2810 {
	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);

		int width, height;
		int length;
		long result;
		// ����, ���� �Է�
		width = scanner.nextInt();
		height = scanner.nextInt();
		//�Է� üũ
		if (width < 1 || width > 1000000 || height < 1 || height > 1000000) {
			System.out.println("INPUT ERROR!");
			System.exit(0);
		}
		//Ÿ���� �Ѻ��� ���̰� �ٴ��� ���� ������ �ִ� ������� �� �ּ��� ���� �ٴ��� ä�� �� �ִ�.
		//�Ѻ��� ����
		length = get_gcd(width, height);
		//Ÿ�� ���� = �ٴ� ���� / ���簢�� ����
		result = (long)width/length*(long)height/length;
		System.out.println(result);

		
	}
	//�ִ� ����� ���ϴ� �Լ� 
	static int get_gcd(int a, int b){
		if(a%b==0) {
			return b;
		}
		return get_gcd(b, a%b);
	}
}
