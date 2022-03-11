/**
 * Alibaba.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package algorithm.lru;

/**
 *
 * @author wenxiangqin
 * @version $Id: Node.java, v 0.1 2022-03-10 8:49 下午 wenxiangqin Exp $$
 */
public class Node {

    public Node next;

    public Node prev;

    public int key,value;

    public Node(int key, int value) {
        this.key = key;
        this.value = value;
    }
}