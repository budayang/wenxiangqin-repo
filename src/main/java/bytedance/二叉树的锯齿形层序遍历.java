package bytedance;

import java.util.*;

public class 二叉树的锯齿形层序遍历 {

    public List<List<Integer>> zigzagLevelOrder(二叉树的层序遍历.TreeNode root) {

        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<二叉树的层序遍历.TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean flag = true;
        while (!nodeQueue.isEmpty()) {
            Deque<Integer> queue = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; i++) {
                二叉树的层序遍历.TreeNode node = nodeQueue.poll();
                if (flag) {
                    queue.addLast(node.val);
                } else {
                    queue.addFirst(node.val);
                }
                if (node.left != null) {
                    nodeQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                }
            }
            ret.add(new LinkedList<>(queue));
            flag = !flag;
        }
        return ret;
    }
}
