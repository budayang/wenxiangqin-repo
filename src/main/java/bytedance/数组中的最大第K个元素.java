package bytedance;

import java.util.PriorityQueue;

public class 数组中的最大第K个元素 {

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>((n1, n2) -> n1-n2);
        for(int i : nums) {
            p.add(i);
            if (p.size() > k) {
                p.poll();
            }
        }
        return p.poll();
    }
}
