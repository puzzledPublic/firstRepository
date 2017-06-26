package java8;

import java.util.Scanner;

//����
//3������ ����� �ϴ� ������ ����ÿ�
//"i a"�� a��� ���� ���ÿ� ����. (1 <= a <= 10,000)
//"o"�� ���ÿ��� ����Ʈ�� ���� �� �����͸� ���, ������ ����ִٸ� "empty"���
//"c"�� ���ÿ� �׿��ִ� �������� ������ ���
//�Է�: ù �ٿ� N�� �־����� N�� �־����� ����� ��(1<= N <= 100)
//     N+1�ٱ��� N���� ����� �־�����.
public class Jungol1102 {
	static int stack[] = new int[101];
	static int top = -1;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n, number;
		n = scanner.nextInt();
		char instruction;
		for(int i = 0; i < n; i++){
			instruction = scanner.next().charAt(0);
			switch(instruction){
			case 'i':
				number = scanner.nextInt();
				push(number);
				break;
			case 'o':
				number = pop();
				if(number == -1){
					System.out.println("empty");
				}else{
					System.out.println(number);
				}
				break;
			case 'c':
				System.out.println(top+1);
				break;
			}
		}
		
	}
	static boolean push(int a){
		if(top == stack.length-1){
			return false;
		}
		top++;
		stack[top] = a;
		return true;
	}
	static int pop(){
		if(top == -1){
			return -1;
		}
		int item;
		item = stack[top];
		top--;
		return item;
	}
}
