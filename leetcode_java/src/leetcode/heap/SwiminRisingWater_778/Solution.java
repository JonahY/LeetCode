package leetcode.heap.SwiminRisingWater_778;

public class Solution {
    public static void main(String[] args) {
        SwiminRisingWater solution = new SwiminRisingWater();
        int[][] grid = {{0,2},{1,3}};
        int res = solution.swimInWater(grid);
        int resII = solution.swimInWaterII(grid);
        System.out.println(res);
        System.out.println(resII);
    }
}
