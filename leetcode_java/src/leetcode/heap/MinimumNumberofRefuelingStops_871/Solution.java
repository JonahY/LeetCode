package leetcode.heap.MinimumNumberofRefuelingStops_871;

public class Solution {
    public static void main(String[] args) {
        MinimumNumberofRefuelingStops solution = new MinimumNumberofRefuelingStops();
        int res = solution.minRefuelStops(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}});
        int resII = solution.minRefuelStopsII(100, 10, new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}});
        System.out.println(res);
        System.out.println(resII);
    }
}
