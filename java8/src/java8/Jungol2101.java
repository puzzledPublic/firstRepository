package java8;

import java.util.Scanner;

//���Ӻκ��ִ��
//���ӵ� N���� �Ǽ��� ���� �� �� �� �̻��� ���ӵ� ������ ���� �ִ밡 �Ǵ� �κ��� ã�� �� ���� ����϶�
//1 <= N <= 10,000�� N���� �Ǽ����� �Է����� �־�����. 
//�Ҽ��� ���� ��° �ڸ����� �ݿø��Ͽ� �Ҽ��� ���� ��° �ڸ����� ���
public class Jungol2101 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n;
		n = scanner.nextInt();
		double[] silsu = new double[n];
	
		for(int i = 0 ; i < n; i++){
			silsu[i] = scanner.nextDouble();
		}
		
		double ret = 0.0;
		for(int i = 0 ; i < n; i++){
			ret = Math.max(ret, mSilsu(i, silsu));
		}
		System.out.printf("%.3f", ret);
	}
	static double mSilsu(int n, double[] silsu){
		if(n < 2){
			return silsu[0]; 
		}
		double ret = silsu[n-1];
		//for(int i = 0; i < n ;i++){
			ret = Math.max(ret, ret*mSilsu(n-1, silsu));
		//}
		return ret;
	}

}
