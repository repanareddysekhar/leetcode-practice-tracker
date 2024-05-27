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
class Solution {
    // Use inorder traversal
    int cnt;
    public int kthSmallest(TreeNode root, int k) {
        cnt = k;
        return inOrder(root);
    }

    private int inOrder(TreeNode root) {
        if(null == root) return -1;

        int ans = inOrder(root.left);
        if(ans != -1) return ans;
        if(cnt == 1) return root.val;
        cnt--;
        return inOrder(root.right);
    }
}