package leetcode.dp.WildcardMatching_44;

public class Solution {
    public static void main(String[] args) {
        WildcardMatching solution = new WildcardMatching();
        boolean res = solution.isMatch("adceb", "a*b");
        System.out.println(res);
    }
}
