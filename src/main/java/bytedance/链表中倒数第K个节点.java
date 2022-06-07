package bytedance;

public class 链表中倒数第K个节点 {

    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode frontNode = head,behindNode = head;
        while (frontNode != null && k > 0) {
            frontNode = frontNode.next;
            k--;
        }

        while (frontNode != null) {
            frontNode = frontNode.next;
            behindNode = behindNode.next;
        }

        return behindNode;
    }

    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }
}
