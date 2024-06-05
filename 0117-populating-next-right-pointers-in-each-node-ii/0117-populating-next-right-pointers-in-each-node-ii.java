/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if(null == root) return root;

        Queue<Node> q = new LinkedList<>();
        q.add(root);
        Node node = null;

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0; i<size; i++) {
                Node prev = node;
                node = q.poll();

                if(i > 0) prev.next = node;

                if(null != node.left) q.add(node.left);
                if(null != node.right) q.add(node.right);
            }
            node.next = null;
        }


        return root;
    }
}