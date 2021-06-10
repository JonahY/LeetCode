package leetcode.dp.RaceCar_818;

public class RaceCar {
    public int racecar(int target) {
        //处理边界
        if (target <= 0) {
            return 0;
        }

        int[] dp = new int[target + 2];
        //dp[0]=0
        dp[1]=1; //A
        dp[2]=4; //AARA 或者 ARRA

        int k = 2;
        // S记录连续k个A指令，达到的位置
        int S = 3;
        for (int i = 3; i <= target; i++) {
            if(i == S) {
                dp[i] = k++;
                // 2^k - 1
                S = (1<<k) - 1;
            } else {
                // 情况1：连续k个A后，回退
                dp[i] = k + 1 + dp[S-i];
                // 情况2：连续k-1个A后，回退(0/1/.../k-2)步后，再前进
                for (int back = 0; back <= k-2; back++) {
                    // 回退后还需前进的距离：i+S(back)-S(k-1)
                    int distance = i + (1<<back) - (1<<(k-1));
                    dp[i] = Math.min(dp[i], (k-1)+2+back+dp[distance]);
                }
            }
        }
        return dp[target];
    }
}
