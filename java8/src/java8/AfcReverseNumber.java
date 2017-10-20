package java8;

//숫자 뒤집기 - (문제해결을 위한 창의적 알고리즘)
public class AfcReverseNumber {
	static int first = 1;
	public static void main(String[] args) {
		
		solve(12300700);
		System.out.println();
		System.out.println(solve2(12300700));
		System.out.println(solve3(12300700));
	}
	
	//기본적으로 생각할 수 있는 재귀
	static void solve(int n){
		if(n == 0){
			return;
		}
		if(first == 1 && n%10 == 0){
			solve(n/10);
		}else{
			System.out.print(n%10);
			first = 0;
			solve(n/10);
		}
	}
	//마지막 수를 분리하고 나머지 수를 다음으로 넘김
	static int solve2(int n){
		if(n < 10){
			return n;
		}
		return solve2(n/10) + (n % 10) * (int)Math.pow(10.0, (int)Math.log10(n));
	}
	
	//solve2 개량버전 (첫자리 수, 마지막 수를 분리하고 나머지 가운데 수를 다음으로 넘김)
	static int solve3(int n){
		if(n < 10){
			return n;
		}
		int T = (int)Math.pow(10,(int)Math.log10(n));
		return (n % 10) * T + 10 * solve3((n % T) / 10) + n / T;
	}
}
