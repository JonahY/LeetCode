package leetcode.heap.KthSmallestPrimeFraction_786;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args) {
        KthSmallestPrimeFraction solution = new KthSmallestPrimeFraction();
        int[] res = solution.kthSmallestPrimeFraction(new int[]{1,2,3,5}, 3);
        int[] resII = solution.kthSmallestPrimeFractionII(new int[]{1,2,3,5}, 3);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(resII));
    }
}
