package leetcode.dp.UniquePathsII_63;

public class UniquePathsII {
    private int res = 0;
    private int[][] obstacleGrid;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        this.obstacleGrid = obstacleGrid;
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        helper(m, n, 0, 0);
        return this.res;
    }

    private void helper(int m, int n, int x, int y) {
        if(this.obstacleGrid[y][x] == 1) {
        } else if((x == n - 1) && (y == m - 1)) {
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

    public int uniquePathsWithObstaclesII(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];

        dp[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                    continue;
                }
                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }

}
