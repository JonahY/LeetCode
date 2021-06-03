package leetcode.dp.LongestCommonSubsequence_1143;

public class Solution {
    public static void main(String[] args) {
        LongestCommonSubsequence solution = new LongestCommonSubsequence();
        int res = solution.longestCommonSubsequence("abc", "def");
        int resII = solution.longestCommonSubsequenceII("abc", "def");
        System.out.println(res);
        System.out.println(resII);
    }
}
