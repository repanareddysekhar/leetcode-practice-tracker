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
    public int maxDepth(TreeNode root) {
        if(null == root) return 0;

        Stack<Integer> depthStk = new Stack<>();
        Stack<TreeNode> stk = new Stack<>();
        stk.push(root);
        depthStk.push(1);

        int maxDepth = 1;

        while(!stk.isEmpty()) {
            TreeNode node = stk.pop();
            int currDepth = depthStk.pop();

            maxDepth = Math.max(maxDepth, currDepth);

            if(null != node.left) {
                stk.push(node.left);
                depthStk.push(currDepth + 1);
            }

            if(null != node.right) {
                stk.push(node.right);
                depthStk.push(currDepth + 1);
            }
        }

        return maxDepth;
    }
}