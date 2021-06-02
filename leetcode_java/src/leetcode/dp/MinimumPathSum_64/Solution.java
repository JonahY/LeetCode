package leetcode.dp.MinimumPathSum_64;

public class Solution {
    public static void main(String[] args) {
        MinimumPathSum solution = new MinimumPathSum();
        int[][] grid = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int res = solution.minPathSum(grid);
        System.out.println(res);
    }
}
