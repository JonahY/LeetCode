package leetcode.heap.MinimumCosttoHireKWorkers_857;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCosttoHireKWorkers {
    public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
        int len = quality.length;
        Worker[] workers = new Worker[len];
        for(int i=0; i<len; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }
        Arrays.sort(workers, (a, b)-> Double.compare(a.ratio, b.ratio));
        PriorityQueue<Integer> queue = new PriorityQueue<>((a, b)->b-a);
        int sumq = 0;
        double ans = Double.MAX_VALUE;
        for(Worker worker : workers) {
            sumq += worker.quality;
            queue.offer(worker.quality);
            if(queue.size() > k) {
                sumq -= queue.poll();
            }
            if(queue.size() == k) {
                ans = Math.min(ans, sumq*worker.ratio);
            }
        }
        return ans;
    }

    class Worker {
        int quality;
        int wage;
        double ratio;
        public Worker(int q, int w) {
            this.quality = q;
            this.wage = w;
            this.ratio = (double)w / q;
        }
    }
}