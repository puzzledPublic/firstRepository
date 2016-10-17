package java8;

import java.util.Scanner;

// ���� �б� ȸ���̴�.(��ǥ)
// N���� ���� �б޿� 3���� ȸ�� �ĺ����� �ִ�
// ������ �л����� 3�� �ĺ��� ���� ��ȣ���� 1,2,3���� ǥ���Ҷ� ���� ���� ��ȣ���� ���� �ĺ��� ��ȣ�� �ְ������� ����϶�
// ���� �ĺ��� �� ��ȣ���� ���ٸ� 3���� ���� ���� ���� �ĺ��� �����Ѵ�, 3�� Ƚ���� ���ٸ� 2�� Ƚ���� ���Ѵ�.
// ������ 2���� Ƚ���� ���ٸ� ȸ���� ���� �� �� �����Ƿ� 0�� �ְ� ������ ����Ѵ�.
public class Jungol2460 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n; // �л� ��
		n = scanner.nextInt(); 
		int clazz[][] = new int[n][3]; //�л����� ��ȣ��
		int presidents[][] = new int[3][3]; //�� �ĺ����� ��ȣ�� ����
		int presidentPoint[] = new int[3]; // �� �ĺ����� �� ��ȣ�� ����
		//�Է�
		for(int i = 0; i < clazz.length; i++){
			for(int j = 0 ; j < clazz[0].length; j++){
				clazz[i][j] = scanner.nextInt();
			}
		}
		//�� �ĺ����� ������ ��ȣ�� ���� ó��
		for(int i = 0 ; i < clazz[0].length; i++){
			for(int j = 0 ; j < clazz.length; j++){
				presidentPoint[i]+=clazz[j][i];
				switch(clazz[j][i]){
				case 1:
					presidents[i][0]++;
					break;
				case 2:
					presidents[i][1]++;
					break;
				case 3:
					presidents[i][2]++;
					break;
				}
			}
		}
		//3�� ��� ���� ������ ��� 1,2,3 �������� ��� ����
		if(presidentPoint[0]==presidentPoint[1]&&presidentPoint[1]==presidentPoint[2]){
				System.out.print("0 "+presidentPoint[0]);
				return;
		}
		//2���� ���� ������ ���
		//(1,2)(2,3)(1,3)�� ���� ��츦 ���鼭
		for(int i = 0 ; i < presidentPoint.length - 1;i++){
			for(int j = i+1; j <presidentPoint.length; j++){
				//�� ���� ������ ������ �� �� ���� Ŭ��
				if(presidentPoint[i] == presidentPoint[j] && presidentPoint[i] > presidentPoint[3-(i+j)]){
					//�� ���� ��ȣ��3�� ���� �� ������
					if(presidents[i][2]>presidents[j][2]){
						System.out.println((i+1)+" "+presidentPoint[i]);
						return;
					}
					//��ȣ�� 3 ������ ���ٸ�
					else if(presidents[i][2]==presidents[j][2]){
						//��ȣ�� 2�� ���� ���� �� ������
						if(presidents[i][1]>presidents[j][1]){
							System.out.println((i+1)+" "+presidentPoint[i]);
							return;
						}
						//��ȣ�� 2 ������ ���ٸ�
						else if(presidents[i][1]==presidents[j][1]){
							//�ƹ��� ������ ���� �����Ƿ� 0���� ���
							System.out.println("0 "+presidentPoint[i]);
							return;
						}
						else{
							System.out.println((j+1)+" "+presidentPoint[j]);
							return;
						}
					}
					else{
						System.out.println((j+1)+" "+presidentPoint[j]);
						return;
					}
				}
			}
		}
		//�´� ������ �ٸ� ���
		int highest[][] = new int[1][2];
		highest[0][1] = 0;
		for(int i = 0 ; i < presidentPoint.length; i++){
				if(highest[0][1] < presidentPoint[i]){
					highest[0][0] = i;
					highest[0][1] = presidentPoint[i];
				}

		}
		System.out.println((highest[0][0]+1)+" "+highest[0][1]);
	}
}
