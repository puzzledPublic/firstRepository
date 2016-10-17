package java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/*
 * ��Ÿ������ ���� ū �簢���� ���̸� ã�� ����
 */
public class FenceProblem {

	public static void main(String args[])
	{
		//��Ÿ�� ���̸� ���� ����Ʈ
		List<Integer> list = new ArrayList<>();
		//�Է�
		Scanner input = new Scanner(System.in);
		//��Ÿ�� ����
		int n = input.nextInt();
		//��Ÿ������ ���� �Է�
		for(int i = 0 ; i < n ; i++)
		{
			list.add(input.nextInt());
		}
		//��������
		System.out.println(solve(list, 0, n-1));
		
	}
	public static int solve(List<Integer> list, int left, int right)
	{
		//��Ÿ���� �� ���� ��� 
		if(left == right)
		{
			return list.get(left);
		}
		//��Ÿ���� �߰� ��ġ
		int mid = (left+right)/2;
		//���� ���������� ���� ��������
		int ret = Math.max(solve(list, left, mid), solve(list, mid+1, right));
		//���ʰ� �����ʱ������� ��ġ�� ��Ÿ������ ����ϱ� ����
		int lo = mid, hi = mid+1;
		//�߰� ��ġ�� ��Ÿ�� ���̿� ������ ��Ÿ���� ���� �� ª������ ����
		int height = Math.min(list.get(lo), list.get(hi));
		//�� ������ ��Ÿ���� ����(������ ��Ÿ������ ����)�� ���� ������ ��
		ret = Math.max(ret, height*2);
		//�߰�(lo)-> ����(left), �߰� ��(hi)->������(right)����
		while(left < lo || hi < right)
		{
			//lo-1�� hi+1�� ��Ÿ�� ���̰� �������� �� ��ٸ�
			if(hi < right && (lo == left || list.get(lo-1) < list.get(hi+1)))
			{
				//���������� �̵�(������ó��)
				hi++;
				//���� ���̿� hi��ġ�� ���� �� ª�� �� ����
				height = Math.min(height, list.get(hi));
			}
			//������ �� ���
			else
			{
				//�������� �̵�
				lo--;
				//���� ���̿� lo��ġ�� ���� �� ª�� �� ����
				height = Math.min(height, list.get(lo));
			}
			//���� ����(ret)�� ��� ���� ����(����(height)*�غ�(hi-lo+1))�� ū �� ����
			ret = Math.max(ret, height * (hi - lo + 1));
		}
		//��� ����
		return ret;
	}
}
