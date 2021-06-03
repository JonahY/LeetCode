package leetcode.dp.StoneGame_877;

public class StoneGame {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int[][] dp = new int[n][n];

        for (int i = 0; i < piles.length; i++) {
            dp[i][i] = piles[i];
        }
        for (int i = n - 2; i > -1; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }
        return dp[0][n - 1] > 0;
    }

    public boolean stoneGameII(int[] piles) {
        int n = piles.length;
        int[] dp = new int[n];

        for (int i = 0; i < piles.length; i++) {
            dp[i] = piles[i];
        }
        for (int i = n - 2; i > -1; i--) {
            for (int j = i + 1; j < n; j++) {
                dp[j] = Math.max(piles[i] - dp[j], piles[j] - dp[j - 1]);
            }
        }
        return dp[n - 1] > 0;
    }
}
