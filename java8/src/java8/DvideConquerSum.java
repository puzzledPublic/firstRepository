package java8;

public class DvideConquerSum {

	public static void main(String args[])
	{
		//���� ������ �Լ� ȣ���ϴ� Ƚ���� �� ��� ����
		long start,end,start2,end2;
		start = System.currentTimeMillis();
		System.out.println("result: "+fastSum(20000));
		end =System.currentTimeMillis();
		start2 = System.currentTimeMillis();
		System.out.println("result2: "+fastSum2(20000));
		end2 =System.currentTimeMillis();
		System.out.println("time: "+(end-start)/1000.0);
		System.out.println("time2: "+(end2-start2)/1000.0);
	}
	//���� �������� �����ϴ� 1���� n������ ��
	public static int fastSum(int n)
	{
		if(n == 1) return 1;
		if(n%2!=0) return fastSum(n-1) + n;
		return 2 * fastSum(n/2) +(n/2)*(n/2);
	}
	//�ܼ� ��ͷ� �����ϴ� 1���� n������ ��
	public static int fastSum2(int n)
	{
		if(n == 1) return 1;
		return fastSum2(n-1)+n;
	}
}
