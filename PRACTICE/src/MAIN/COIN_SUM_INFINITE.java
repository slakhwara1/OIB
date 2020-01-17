package MAIN;

public class COIN_SUM_INFINITE {

	int mod = 1000007;

	public int coinchange2(int[] coins, int amount) {
		int[][] dp = new int[coins.length + 1][amount + 1];
		for (int i = 0; i < dp.length; i++)
			dp[i][0] = 1;
		for (int i = 1; i < dp[0].length; i++)
			dp[0][i] = 0;

		for (int i = 1; i <= coins.length; i++) {
			for (int j = 1; j <= amount; j++) {
				int coinAmount = coins[i - 1];
				if (coinAmount <= j) {
					int includingCoin = dp[i][j - coinAmount] % mod;
					int excludingCoin = dp[i - 1][j] % mod;
					dp[i][j] = (includingCoin % mod + excludingCoin % mod) % mod;
				} else
					dp[i][j] = dp[i - 1][j] % mod;
			}
		}
		util.PRINT_ARRAYS.printMatrix(dp);
		return dp[dp.length - 1][dp[0].length - 1];
	}

	public static void main(String[] args) {
//		System.out.println(new COIN_SUM_INFINITE().coinchange2(new int[] { 1, 2, 3 }, 4));
		System.out.println(new COIN_SUM_INFINITE()
				.coinchange2(new int[] { 7, 10, 2, 11, 19, 15, 21, 5, 24, 16, 30, 23, 18, 17, 14, 27, 20, 22 }, 2));
	}
}
