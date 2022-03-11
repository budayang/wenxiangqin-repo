/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package algorithm.lru;

/**
 *
 * @author wenxiangqin
 * @version $Id: DoubleLinkedList.java, v 0.1 2022-03-10 8:51 下午 wenxiangqin Exp $$
 */
public class DoubleLinkedList {

    private Node head;

    private Node tail;

    private int size;

    public DoubleLinkedList() {
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    public void addFirst(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        size++;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeLast() {
        if (head.next == tail) {
            return null;
        }
        Node last = tail.prev;
        remove(last);
        return last;
    }

    public int size() {
        return size;
    }
}