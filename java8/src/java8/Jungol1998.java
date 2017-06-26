package java8;

import java.util.Scanner;

//����
//0~9�� �̷���� N���� ���ڰ� ������ ������ �ִ�.
//�� �������� �����ؼ� Ŀ���ų� �����ؼ� �۾����� (���� �� ����) ���� �� ���� �� ������ ���̸� ����϶�
//�Է�: ������ ���� N(1 <= N <= 100,000), N���� �������� ���е� 0~9������ ���ڵ�
public class Jungol1998 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		int[] sequence = new int[n];
		for(int i = 0 ; i < n ; i++){
			sequence[i] = scanner.nextInt();
		}
		if(n == 1){
			System.out.println(1);
			return;
		}
		int max = 0;
		int hSequence = 1;
		int lSequence = 1;
		
		for(int i = 0 ; i < sequence.length-1; i++){
			if(sequence[i] <=sequence[i+1]){
				hSequence++;
				if(i==n-2){
					max = Math.max(max, hSequence);
				}
			}else{
				max = Math.max(max, hSequence);
				hSequence = 1;
			}
			if(sequence[i]>=sequence[i+1]){
				lSequence++;
				if(i==n-2){
					max = Math.max(max, lSequence);
				}
			}else{
				max = Math.max(max, lSequence);
				lSequence = 1;
			}
		}
		
		System.out.println(max);
	}
}
