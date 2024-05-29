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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> res = new ArrayList<>();
        if(null == root) return res;

        List<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        dfs(root, res, temp, targetSum-root.val);
        return res;
    }

    void dfs(TreeNode root, List<List<Integer>> res, List<Integer> temp, int target) {
        if(0 == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(temp));
            return;
        }

        if(null != root.left) {
            temp.add(root.left.val);
            dfs(root.left, res, temp, target-root.left.val);
            temp.remove(temp.size()-1);
        }

        if(null != root.right) {
            temp.add(root.right.val);
            dfs(root.right, res, temp, target-root.right.val);
            temp.remove(temp.size()-1);
        }
    }
}