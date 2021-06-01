package leetcode.dp.UniquePaths_62;

import java.util.Arrays;

public class UniquePaths {
    private int res = 0;
    private int x = 0;
    private int y = 0;

    public int uniquePaths(int m, int n) {
        helper(m, n, this.x, this.y);
        return this.res;
    }

    private void helper(int m, int n, int x, int y) {
        if((x == n - 1) && (y == m - 1)) {
            this.res++;
        } else if(x == n - 1) {
            helper(m, n, x, y + 1);
        } else if(y == m - 1) {
            helper(m, n, x + 1, y);
        } else {
            helper(m, n, x, y + 1);
            helper(m, n, x + 1, y);
        }
    }

    public int uniquePathsII(int m, int n) {
        int[][] dp = new int[m][n];
        Arrays.fill(dp[0], 1);
        for (int i = 1; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public int uniquePathsIII(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                cur[j] = cur[j] + cur[j - 1];
            }
        }
        return cur[n - 1];
    }

}
