package leetcode.heap.SwiminRisingWater_778;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class SwiminRisingWater {
    public int swimInWater(int[][] grid) {
        int N = grid.length;
        boolean[][] visited = new boolean[N][N];
        int maxTime = 0;
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        PriorityQueue<Entry> queue = new PriorityQueue<Entry>(new Comparator<Entry>() {
            @Override
            public int compare(Entry entry1, Entry entry2) {
                return entry1.val - entry2.val;
            }
        });
        queue.offer(new Entry(0, 0, grid[0][0]));
        while (!queue.isEmpty()) {
            Entry entry = queue.poll();
            if (visited[entry.i][entry.j]) {
                continue;
            }
            maxTime = Math.max(maxTime, entry.val);
            visited[entry.i][entry.j] = true;
            if (entry.i == (N - 1) && entry.j == (N - 1)) {
                break;
            }
            for (int[] direction : directions) {
                int x = entry.i + direction[0];
                int y = entry.j + direction[1];
                if (x >= 0 && x < N && y >= 0 && y < N && !visited[x][y]) {
                    queue.offer(new Entry(x, y, grid[x][y]));
                }
            }
        }
        return maxTime;
    }

    public int swimInWaterII(int[][] grid) {
        int n = grid.length;
        int left = 0, right = n * n - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (check(grid, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean check(int[][] grid, int threshold) {
        if (grid[0][0] > threshold) {
            return false;
        }
        int n = grid.length;
        boolean[][] visited = new boolean[n][n];
        visited[0][0] = true;
        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0, 0});

        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        while (!queue.isEmpty()) {
            int[] square = queue.poll();
            int i = square[0], j = square[1];

            for (int[] direction : directions) {
                int ni = i + direction[0], nj = j + direction[1];
                if (ni >= 0 && ni < n && nj >= 0 && nj < n) {
                    if (!visited[ni][nj] && grid[ni][nj] <= threshold) {
                        queue.offer(new int[]{ni, nj});
                        visited[ni][nj] = true;
                    }
                }
            }
        }
        return visited[n - 1][n - 1];
    }
}

// 优先队列中的数据结构。其中 (i,j) 代表坐标，val 代表水位。
class Entry {
    int i;
    int j;
    int val;

    public Entry(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }
}