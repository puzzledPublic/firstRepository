package java8;

import java.util.Scanner;

//10������ 2, 8, 16 ������...
//�Է� N(1 <= N <= 100,000), B(2, 8, 16)
//16���������� 10~16�� A, B, C, D, E, F�� ��Ÿ��
public class Jungol1534 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int decimal, type;
		decimal = scanner.nextInt();
		type = scanner.nextInt();
		
		switch(type){
		case 2:
			decimalToBi(decimal);
			break;
		case 8:
			decimalToEi(decimal);
			break;
		case 16:
			decimalToSi(decimal);
			break;
		}
	}
	static void decimalToBi(int decimal){
		
		if(decimal == 0){
			return;
		}
		decimalToBi(decimal/2);
		System.out.print(decimal%2);
	}
	static void decimalToEi(int decimal){
		if(decimal == 0){
			return;
		}
		decimalToEi(decimal/8);
		System.out.print(decimal%8);
	}
	static void decimalToSi(int decimal){
		if(decimal == 0){
			return;
		}
		decimalToSi(decimal/16);
		if(decimal%16>=10){

			System.out.print((char)(decimal%16+55));
		}
		else{
			System.out.print(decimal%16);
		}
	}
}
