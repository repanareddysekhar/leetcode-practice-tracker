/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(null == root) return "#";
        return String.valueOf(root.val) + " " + serialize(root.left) + " " + serialize(root.right);
    }

    int pos = -1;
    public TreeNode deserialize(String data) {
        return deserialize(data.split(" "));
    }

    private TreeNode deserialize(String[] data) {
        pos++;
        if(data[pos].equals("#")) return null;
        TreeNode root = new TreeNode(Integer.parseInt(data[pos]));
        root.left = deserialize(data);
        root.right = deserialize(data);
        return root;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));