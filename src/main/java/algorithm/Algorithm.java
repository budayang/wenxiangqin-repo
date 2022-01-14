/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package algorithm;

/**
 *
 * @author wenxiangqin
 * @version $Id: Algorithm.java, v 0.1 2022-01-13 3:44 下午 wenxiangqin Exp $$
 */
public class Algorithm {
    public static int dominantIndex(int[] nums) {
        // nums = [1,2,3,4]
        // [0,0,3,2]
        if (nums.length == 1) {
            return 0;
        }
        int max = 0;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max < nums[i]) {
                max = nums[i];
                index = i;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (max == nums[i]) {
                continue;
            }
            if (max < 2 * nums[i]) {
                return -1;
            }
        }
        return index;
    }

    StringBuilder s1 = new StringBuilder("");
    StringBuilder s2 = new StringBuilder("");
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while (l1 != null || l2 != null || carry != 0) {
            int l1val = l1 != null ? l1.val : 0;
            int l2val = l2 != null ? l2.val : 0;
            int sum = l1val + l2val + carry;
            carry = sum / 10;

            ListNode listNode = new ListNode(sum % 10);
            cursor.next = listNode;
            cursor = listNode;

            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        return root.next;
    }

    class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static void main(String[] args) {
        int[] nums = new int[] {0,0,3,2};
        dominantIndex(nums);
    }

}