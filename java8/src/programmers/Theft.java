package programmers;


//도둑질
public class Theft {
	public static void main(String[] args) {
		int[] money = {2, 3, 1};
		System.out.println(solution(money));
	}
	
	static int solution(int[] money) {
        int answer = 0;
        int[] dp = new int[money.length];
        dp[0] = dp[1] = money[0];
        for(int i = 2; i < money.length - 1; i++) {
        	dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }
        answer = dp[money.length - 2];
        dp[0] = 0;
        dp[1] = money[1];
        for(int i = 2; i < money.length; i++) {
        	dp[i] = Math.max(dp[i - 2] + money[i], dp[i - 1]);
        }
        answer = Math.max(answer, dp[money.length - 1]);
        return answer;
    }
}
