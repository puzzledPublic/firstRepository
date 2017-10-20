package java8;

//nCr n개중 r개를 고르는 경우의 수를 출력하라 (문제해결을 위한 창의적 알고리즘)
//nCr = n! / r! * (n - r)!
//위 공식은 n or r이 크면 팩토리얼때문에 컴퓨터 계산시 오래걸림
public class AfcCombination_S {
	public static void main(String[] args) {
		
		System.out.println(solve(5,2));
		System.out.println(solve2(5,2));
	}
	//f(n,r) = n (n == r)
	//f(n,r) = 1 (r == 1)
	//f(n,r) = f(n-1, r-1) + f(n-1, r)  (1<r<n)
	static int solve(int n, int r){
		
		if(n == r){
			return 1;
		}
		else if(r == 1){
			return n;
		}
		else{
			return solve(n - 1, r - 1) + solve(n - 1, r);
		}
	}
	//개량 버전 f(n,r) = f(n, r-1) * (n - r + 1) / r (1<r<n)
	static int solve2(int n, int r){
		if(n == r){
			return 1;
		}
		else if(r == 1){
			return n;
		}
		else{
			//return solve2(n, r - 1) * (n - r + 1) / r; //오버플로우 발생 가능성
			return (n - r + 1) / r * solve2(n, r - 1);
		}
	}
}
