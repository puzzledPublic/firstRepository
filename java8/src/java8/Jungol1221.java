package java8;

import java.util.Scanner;

//���� ǥ���
//�Է��� ù �ٿ��� �� �ԷµǴ� �����ڿ� �ǿ������� ������ �� M(3��M��11 )�� �ԷµǸ�, �� �����ٿ� M���� �����ڿ� �ǿ����ڰ� �� ĭ���� ���� �� �ΰ� �Էµȴ�. 
//�ǿ����� X �� 0��X��9 �� ������ ������ �����̸�, �����ڴ� ��Ģ������ '*', '/', '+', '-'�� �� ������ �Էµȴ�. 0���� ������ ���� �Էµ��� �ʴ´�.
public class Jungol1221 {
	static int stack[] = new int[6];
	static int top = -1;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int m;
		m = scanner.nextInt();
		int op1, op2;
		int pp;

		for (int i = 0; i < m; i++) {

			pp = scanner.next().charAt(0);
			switch (pp) {
			case '+':
				op1 = pop();
				op2 = pop();
				op1 = op1 + op2;
				push(op1);
				break;
			case '-':
				op1 = pop();
				op2 = pop();
				op1 = op2 - op1;
				push(op1);
				break;
			case '/':
				op1 = pop();
				op2 = pop();
				op1 = op2 / op1;
				push(op1);
				break;
			case '*':
				op1 = pop();
				op2 = pop();
				op1 = op1 * op2;
				push(op1);
				break;
			default:
				push(pp - 48);
				break;
			}
		}
		System.out.println(pop());
	}

	static boolean push(int a) {
		if (top == stack.length - 1) {
			return false;
		}
		top++;
		stack[top] = a;
		return true;
	}

	static int pop() {
		if (top == -1) {
			return -1;
		}
		int item;
		item = stack[top];
		top--;
		return item;
	}
}
