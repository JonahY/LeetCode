package leetcode.heap.CheapestFlightsWithinKStops_787;

public class Solution {
    public static void main(String[] args) {
        CheapestFlightsWithinKStops solution = new CheapestFlightsWithinKStops();
        int res = solution.findCheapestPrice(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1);
        int resII = solution.findCheapestPriceII(3, new int[][]{{0, 1, 100}, {1, 2, 100}, {0, 2, 500}}, 0, 2, 1);
        System.out.println(res);
        System.out.println(resII);
    }
}
