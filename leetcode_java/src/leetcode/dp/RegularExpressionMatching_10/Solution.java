package leetcode.dp.RegularExpressionMatching_10;

public class Solution {
    public static void main(String[] args) {
        RegularExpressionMatching solution = new RegularExpressionMatching();
        boolean res = solution.isMatch("aab", "c*a*b");
        System.out.println(res);
    }
}
