package leetcode.dp.MaximumSubarray_53;

import java.util.Arrays;

class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        int[] dp = new int [n];
        dp[0] = nums[0];

        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        return Arrays.stream(dp).max().getAsInt();
    }

    public class Status {
        public int lSum, rSum, mSum, iSum;

        public Status(int lSum, int rSum, int mSum, int iSum) {
            this.lSum = lSum;
            this.rSum = rSum;
            this.mSum = mSum;
            this.iSum = iSum;
        }
    }

    public int maxSubArrayII(int[] nums) {
        return getInfo(nums, 0, nums.length - 1).mSum;
    }

    private Status getInfo(int[] a, int l, int r) {
        if (l == r) {
            return new Status(a[l], a[l], a[l], a[l]);
        }
        int m = (l + r) >> 1;
        Status lSub = getInfo(a, l, m);
        Status rSub = getInfo(a, m + 1, r);
        return pushUp(lSub, rSub);
    }

    private Status pushUp(Status l, Status r) {
        int iSum = l.iSum + r.iSum;
        int lSum = Math.max(l.lSum, l.iSum + r.lSum);
        int rSum = Math.max(r.rSum, r.iSum + l.rSum);
        int mSum = Math.max(Math.max(l.mSum, r.mSum), l.rSum + r.lSum);
        return new Status(lSum, rSum, mSum, iSum);
    }
}
