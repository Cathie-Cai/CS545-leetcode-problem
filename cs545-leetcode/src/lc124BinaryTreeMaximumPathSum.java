
// ref:https://leetcode.com/problems/binary-tree-maximum-path-sum/
// difficult level: hard
public class lc124BinaryTreeMaximumPathSum {
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
    int res = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return res;
    }

    public int helper(TreeNode root) {
        if (root == null) return 0;

        int left = helper(root.left); // 以左孩子为root的单条path的最大和
        int right = helper(root.right);

        res = Math.max(Math.max(left, 0) + Math.max(right, 0) + root.val, res);

        return Math.max(Math.max(left, right), 0) + root.val;

    }
}
