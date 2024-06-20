class MinStack {

    class Node {
        Node next;
        int min;
        int val;

        Node(Node next, int min, int val) {
            this.next = next;
            this.min = min;
            this.val = val;
        }
    }

    Node head;

    public MinStack() {
    }
    
    public void push(int val) {
        if(null == head)
            head = new Node(null, val, val);
        else
            head = new Node(head, Math.min(val, head.min), val);
    }
    
    public void pop() {
        head = head.next;
    }
    
    public int top() {
        return head.val;
    }
    
    public int getMin() {
        return head.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */