package leetcode.heap.KthSmallestPrimeFraction_786;

import java.util.PriorityQueue;

public class KthSmallestPrimeFraction {
    public int[] kthSmallestPrimeFraction(int[] A, int K) {
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((a, b) ->
                A[a[0]] * A[b[1]] - A[a[1]] * A[b[0]]);

        for (int i = 1; i < A.length; ++i)
            pq.add(new int[]{0, i});

        while (--K > 0) {
            int[] frac = pq.poll();
            if (frac[0]++ < frac[1] + 1)
                pq.offer(frac);
        }

        int[] ans = pq.poll();
        return new int[]{A[ans[0]], A[ans[1]]};
    }

    public int[] kthSmallestPrimeFractionII(int[] A, int K) {
        int n = A.length;
        double left = 0, right = 1, mid;
        while (true) {
            mid = (left + right) / 2;
            int count = 0;
            int j = 0;
            int[] maxIndex = {0, 1};
            for (int i = 0; i < n; i++) {
                while (j < n && A[i] >= A[j] * mid) ++j;
                count += n - j;
                if (j < n && A[i] * maxIndex[1] > A[j] * maxIndex[0]) {
                    maxIndex = new int[]{A[i], A[j]};
                }
            }
            if (count > K) right = mid;
            else if (count < K) left = mid;
            else return maxIndex;
        }
    }
}
