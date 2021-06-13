package leetcode.heap.MinimumNumberofRefuelingStops_871;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumNumberofRefuelingStops {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int res = 0;
        int prev = 0;
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b) -> b - a);
        int[][] stations_new = new int[stations.length + 1][2];
        System.arraycopy(stations, 0, stations_new, 0, stations.length);
        stations_new[stations.length] = new int[]{target, (int) Double.POSITIVE_INFINITY};

        for (int[] station : stations_new) {
            int location = station[0], capacity = station[1];
            startFuel -= location - prev;
            while (!heap.isEmpty() && (startFuel < 0)) {
                startFuel += heap.poll();
                res += 1;
            }
            if (startFuel < 0) return -1;
            heap.offer(capacity);
            prev = location;
        }
        return res;
    }

    public int minRefuelStopsII(int target, int startFuel, int[][] stations) {
        int[] dp = new int[stations.length + 1];
        dp[0] = startFuel;
        for (int i = 0; i < stations.length; i++) {
            int location = stations[i][0];
            int capacity = stations[i][1];
            for (int t = i; t > -1; t--) {
                if (dp[t] >= location) {
                    dp[t+1] = Math.max(dp[t+1], dp[t] + capacity);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[i] >= target) return i;
        }

        return -1;
    }
}
