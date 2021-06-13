package leetcode.heap.ReachableNodesInSubdividedGraph_882;

public class Solution {
    public static void main(String[] args) {
        ReachableNodesInSubdividedGraph solution = new ReachableNodesInSubdividedGraph();
        int res = solution.reachableNodes(new int[][]{{0, 1, 10}, {0, 2, 1}, {1, 2, 2}}, 6, 3);
        System.out.println(res);
    }
}
