package leetcode.heap.MinimumCosttoHireKWorkers_857;

public class Solution {
    public static void main(String[] args) {
        MinimumCosttoHireKWorkers solution = new MinimumCosttoHireKWorkers();
        double res = solution.mincostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3);
        System.out.println(res);
    }
}
