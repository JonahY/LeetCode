package leetcode.dp.LongestCommonSubsequence_1143;

public class LongestCommonSubsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int [n1 + 1][n2 + 1];

        for (int i = 1; i < n1 + 1; i++) {
            for (int j = 1; j < n2 + 1; j++) {
                dp[i][j] = text1.charAt(i - 1) == text2.charAt(j - 1) ? dp[i - 1][j - 1] + 1 : Math.max(dp[i][j - 1], dp[i - 1][j]);
            }
        }
        return dp[n1][n2];
    }

    public int longestCommonSubsequenceII(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        int pre = 0;
        int k = 0;
        int[] dp = new int[m];

        for(int i = 0; i < n; i++){
            pre = 0;
            k = 0;
            for(int j = 0; j < m; j++){
                if(t1[i] == t2[j])
                    k = pre + 1;
                else
                    k = Math.max(dp[j], k);
                pre = dp[j];
                dp[j] = k;
            }
        }
        return dp[m-1];
    }
}
