package java8;

public class ClockSync {

	//INF = �Ұ����Ҷ� ����, SWITCHES = ����ġ ����, CLOCKS = �ð� ����
	final static int INF = 9999, SWITCHES = 10, CLOCKS = 16;
	//linked[SWITCHES][CLOCKS] = SWITCHES��° ����ġ�� ������ �ð�� 'x'�� ǥ��, �ƴϸ� '.'
	final static char linked[][] = {"xxx.............".toCharArray(),
									"...x...x.x.x....".toCharArray(),
									"....x.....x...xx".toCharArray(),
									"x...xxxx........".toCharArray(),
									"......xxx.x.x...".toCharArray(),
									"x.x...........xx".toCharArray(),
									"...x..........xx".toCharArray(),
									"....xx.x......xx".toCharArray(),
									".xxxxx..........".toCharArray(),
									"...xxx...x...x..".toCharArray()};
	//���� �Լ�
	public static void main(String args[])
	{
		int clock[] = {6,6,6,12,12,12,12,12,12,12,12,12,12,12,12,12};//{12,6,6,6,6,6,12,12,12,12,12,12,12,12,12,12};
		System.out.println("result: "+solve(clock, 0));
		
	}
	//�ð谡 ��� 12�ø� ����Ű���� Ȯ���ϴ� �Լ�
	public static boolean areAligned(int[] clock)
	{
		for(int i = 0 ;i < clock.length ; i++)
		{
			if(clock[i]!= 12) 
			{
				return false;
			}
		}
		return true;
	}
	//����ġ�� ������ ������ �ð谡 +3�ð� �ǵ��� �ٲٴ� �Լ�
	public static void push(int[] clock, int swtch)
	{
		//�ð� ��������
		for(int i = 0 ; i < CLOCKS; i++)
		{
			//�ش� ����ġ�� ������ �ð���
			if(linked[swtch][i] =='x')
			{
				//+3��
				clock[i] +=3;
				//12�ÿ� +3�ð� �� ���
				if(clock[i] == 15)
				{
					clock[i]=3;
				}
			}
		}
	}
	//����ġ�� ������ ����� �Լ�
	public static int solve(int[] clock, int swtch)
	{
		//����ġ�� ��� 
		if(swtch == SWITCHES) return areAligned(clock) ? 0:INF;
		int ret = INF;
		for(int cnt = 0; cnt <4; cnt++)
		{
			ret = Math.min(ret, cnt+solve(clock, swtch+1));
			push(clock, swtch);
		}
		return ret;
	}
}
