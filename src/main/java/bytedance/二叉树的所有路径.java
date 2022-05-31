package bytedance;

import java.util.ArrayList;
import java.util.List;

public class 二叉树的所有路径 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<String>();
        pathsTrace(root, "", paths);
        return paths;
    }

    public void pathsTrace(TreeNode node, String path, List<String> paths) {
        if (node != null) {
            StringBuilder sb = new StringBuilder(path);
            sb.append(String.valueOf(node.val));

            if (node.left == null && node.right == null) {
                paths.add(sb.toString());
            } else {
                sb.append("->");
                pathsTrace(node.left, sb.toString(), paths);
                pathsTrace(node.right, sb.toString(), paths);
            }
        }
    }


    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

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
}
