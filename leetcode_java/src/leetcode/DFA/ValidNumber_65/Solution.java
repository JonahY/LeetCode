package leetcode.DFA.ValidNumber_65;

public class Solution {
    public static void main(String[] args) {
        ValidNumber solution = new ValidNumber();
        boolean res = solution.isNumber(".1");
        boolean resII = solution.isNumberII(".1");
        System.out.println(res);
        System.out.println(resII);
    }
}
