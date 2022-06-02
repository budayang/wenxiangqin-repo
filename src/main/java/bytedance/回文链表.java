package bytedance;

import java.util.ArrayList;
import java.util.List;

public class 回文链表 {
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        if (head != null) {
            list.add(head.val);
        } else {
            return false;
        }
        ListNode node = head;
        while (node.next != null) {
            node = node.next;
            list.add(node.val);
        }

        for(int i = 0,j = list.size() - 1; i <= list.size()-1 && j >= 0; i++,j--) {
            if (list.get(i) != list.get(j)) {
                return false;
            }
        }
        return true;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
