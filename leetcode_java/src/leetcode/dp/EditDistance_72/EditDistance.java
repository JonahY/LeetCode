package leetcode.dp.EditDistance_72;

import java.util.Arrays;
import java.util.List;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        for (int i = 1; i < n1 + 1; i++) {
            dp[i][0] = dp[i - 1][0] + 1;
        }
        for (int j = 1; j < n2 + 1; j++) {
            dp[0][j] = dp[0][j - 1] + 1;
        }
        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))  dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
            }
        }
        return dp[n1][n2];
    }

    public int minDistanceII(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[] dp = new int[n2 + 1];
        for (int i = 0; i < n2 + 1; i++) {
            dp[i] = i;
        }

        for (int i = 0; i < n1; i++) {
            int leftUp = dp[0];
            dp[0] = i + 1;
            for (int j = 0; j < n2; j++) {
                int min = Math.min(dp[j + 1], dp[j]);
                int tmp = dp[j + 1];
                dp[j + 1] = word2.charAt(j) != word1.charAt(i) ? Math.min(min, leftUp) + 1 :
                        Math.min(min, leftUp - 1) + 1;
                leftUp = tmp;
            }
        }
        return dp[n2];
    }
}
