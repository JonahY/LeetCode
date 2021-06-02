package leetcode.dp.EditDistance_72;

public class Solution {
    public static void main(String[] args) {
        EditDistance solution = new EditDistance();
        int res = solution.minDistance("horse", "ros");
        int resII = solution.minDistanceII("horse", "ros");
        System.out.println(res);
        System.out.println(resII);
    }
}
