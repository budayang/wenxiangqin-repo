package bytedance;

import java.util.ArrayList;
import java.util.List;

public class 二叉树展开为链表 {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<TreeNode>();
        traveNode(root, list);
        for(int i =1; i < list.size(); i++) {
            TreeNode pre = list.get(i-1);
            TreeNode cur = list.get(i);
            pre.right = cur;
            pre.left = null;
        }
    }

    public void traveNode(TreeNode node, List<TreeNode> list) {
        if (node == null) {
            return;
        }
        list.add(node);
        traveNode(node.left, list);
        traveNode(node.right, list);
    }
}
