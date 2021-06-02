package leetcode.dp.UniquePathsII_63;

public class Solution {
    public static void main(String[] args) {
        UniquePathsII solution = new UniquePathsII();
        int[][] obstacleGrid = {{0,0},{0,1}};
        int res = solution.uniquePathsWithObstacles(obstacleGrid);
        int resII = solution.uniquePathsWithObstaclesII(obstacleGrid);
        System.out.println(res);
        System.out.println(resII);
    }
}
