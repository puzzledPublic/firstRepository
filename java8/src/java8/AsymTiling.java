package java8;

import java.util.Arrays;
import java.util.Scanner;

//���Ī Ÿ�ϸ�
//������ 8.12����
//2xn ũ���� ���簢���� 2x1 ũ���� Ÿ�Ϸ� ä������Ѵ�.
//���� ���ļ��� �ȵǸ� 90���� ���� ��� �����ϴ�
//�� �¿��Ī�� ��쿡�� �����Ѵ�. 
//n�� �־����� ������ ���Ī Ÿ�ϸ� ����� ���� ����϶� ( ����� ���� �ſ� Ŭ �� �����ѷ� 1,000,000,007�� ���� �������� ����Ѵ�)
// 1 <= n <= 100
public class AsymTiling {
	static int[] cache = new int[101];
	static int[] cache2 = new int[101];
	final static int mod = 1000000007;
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int width = scanner.nextInt();
		//ĳ�� -1 �� �ʱ�ȭ
		Arrays.fill(cache, -1);
		Arrays.fill(cache2, -1);
		System.out.println(asymTile(width));
	}
	static int asymTile(int width){
		//��Ī�Ǵ� ��츦 ���� ũ�� 2������ width�� Ȧ��, ¦���� ���
		//Ȧ���� ��� ��� 2x1�� Ÿ���� �ְ� �¿�� ��Ī�Ǵ� ���
		//¦���� ��� ��� 1x2�� 2�� Ÿ���� ���Ʒ� �ְ� �¿�� ��Ī�Ǵ� ���� �ܼ��� ��� ��ġ�� �������� ��Ī�� ���
		
		//width�� Ȧ���� �� 1���� ��� 
		if(width%2==1){
			return (tiling(width)-tiling(width/2) + mod)%mod;
		}
		//width�� ¦���� �� 2���� ���
		int ret = tiling(width);
		//�ܼ��� ��� ��ġ�� �������� ��Ī�� ��� (������ �Ǵ� ��츦 �����ϱ� ���� mod�� ����)
		ret = (ret - tiling(width/2)+mod)%mod;
		//��� 1x2�� 2�� Ÿ���� ���Ʒ� �ְ� �¿�� ��Ī�Ǵ� ���
		ret = (ret - tiling(width/2-1)+mod)%mod;
		return ret;
	}
	//������ ���Ī�Ǵ� ��츦 ���� ���
	//���ʿ��� �������ٰ� �����ϰ� ũ�� 4���� ��찡 �ִ�
	static int asymTile2(int width){
		//width�� 2 ���ϸ� ���Ī�� ��찡 �����Ƿ� 0 ����
		if(width <= 2){
			return 0;
		}
		//�޸������̼�
		if(cache2[width] != -1){
			return cache2[width];
		}
		//���� �����ʿ� 2x1Ÿ���� �ϳ��� �ִ� ���(��Ī�� ����̹Ƿ� ���� ������ ���Ī�� �Ǿ����)
		cache2[width] = asymTile2(width-2) % mod;
		//���� �����ʿ� 1x2Ÿ�� 2���� �ִ� ���(��Ī�� ����̹Ƿ� ���� ������ ���Ī�� �Ǿ����)
		cache2[width] = (cache2[width] + asymTile2(width-4)) % mod;
		//���ʿ� 2x1Ÿ�� �ϳ� �����ʿ� 1x2Ÿ�� 2���� �ִ� ���(�̶��� ���Ī�̹Ƿ� ��� ���� ���ϸ� �ȴ�)
		cache2[width] = (cache2[width] + tiling(width-3)) % mod;
		//���ʿ� 1x2Ÿ�� 2�� �����ʿ� 2x1Ÿ�� �ϳ��� �ִ� ���(���Ī�̹Ƿ� ��� ���� ���Ѵ�)
		cache2[width] = (cache2[width] + tiling(width-3)) % mod;
		return cache2[width];
	}
	//��� Ÿ�ϸ� ����� ���� ���ϴ� ��� �Լ�(���Ī+��Ī)
	static int tiling(int width){
		if(width <= 1){
			return 1;
		}
		if(cache[width] != -1){
			return cache[width];
		}
		return cache[width] = (tiling(width-1)+tiling(width-2))%mod;
	}
}
