package leetcode.dp.StoneGame_877;

public class Solution {
    public static void main(String[] args) {
        StoneGame solution = new StoneGame();
        int[] input = {5,3,4,5};
        boolean res = solution.stoneGame(input);
        boolean resII = solution.stoneGameII(input);
        System.out.println(res);
        System.out.println(resII);
    }
}
