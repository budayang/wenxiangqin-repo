package bytedance;

public class 求根节点到叶子节点数字之和 {
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        childSum(0, root);
        return sum;
    }

    public void childSum(int val, TreeNode root) {
        if (root == null) {
            return;
        }
        int k = (val * 10 + root.val);
        if (root.left == null && root.right == null) {
            sum += k;
        }

        childSum(k, root.left);
        childSum(k, root.right);
    }

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
