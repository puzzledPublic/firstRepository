package java8;

import java.util.Scanner;

//�밢�� �������
public class Jungol1495 {

	public static void main(String args[]){
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		zigzag(n);
	}
	public static void zigzag(int n){
		int arr[][] = new int[n][n];
		//0���� �ʱ�ȭ
		for(int i = 0 ; i < n;i++){
			for(int j = 0 ; j<n;j++){
				arr[i][j] = 0;
			}
		}
		//���� �ѹ�
		int num = 1;
		int x=0,y=0;
		//0,0 ��ġ ���� ����
		arr[x][y] = num++;
		//num�� n*n���� ��� �� ������
		while(num <= n*n){
			//�Ʒ����� �����ؼ� ���� �� �ִٸ� ����
			if(x<n-1){
				x++;
				arr[x][y] = num++;
			}//���ٸ� �����ʿ� ����
			else{
				y++;
				arr[x][y] = num++;
			}
			//������ �� �밢�� �������� ���� 
			while(arr[x-1][y+1] == 0){
				x--;
				y++;
				arr[x][y] = num++;
				//�迭�� ũ�⸦ �Ѿ� �˻��ϱ��� break;
				if(x == 0 || y == n-1)break;
			}
			//y�� ���� �����ϸ� �����ʿ� ���� �� �ִٸ� ���� 
			if(y<n-1){
				y++;
				arr[x][y] = num++;
			}//�ƴ϶�� �Ʒ��� ����
			else{
				x++;
				arr[x][y] = num++;
			}
			//n-1,n-1 ��ġ���� �����ϸ� ������.
			if(x == n-1 && y== n-1) break;
			//���� �Ʒ� �밢�� �������� ����
			while(arr[x+1][y-1] == 0){
				x++;
				y--;
				arr[x][y] = num++;
				if(y == 0 || x == n-1)break;
			}
		}
		//���
		for(int i = 0 ; i < n;i++){
			for(int j = 0 ; j<n;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}
