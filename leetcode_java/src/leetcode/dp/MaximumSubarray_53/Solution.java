package leetcode.dp.MaximumSubarray_53;

public class Solution {
    public static void main(String[] args) {
        MaximumSubarray solution = new MaximumSubarray();
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        int res = solution.maxSubArray(nums);
        int resII = solution.maxSubArrayII(nums);
        System.out.println(res);
        System.out.println(resII);
    }
}
