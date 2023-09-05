/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        //put new nodes bw original nodes
        //1 -> 1' -> 2 -> 2'
        Node t = head;
        while(t != null){
            Node n = t.next;
            Node newNode = new Node(t.val);
            t.next = newNode;
            newNode.next = n;
            
            t = n;
        }
        
        t = head;
        while(t != null && t.next != null){
            //next original node
            Node n = t.next.next;
            //set random pointer of new node
            t.next.random = t.random == null? null : t.random.next;
            
            t = n; 
        }
        //build the clone LL using new nodes only
        t = head;
        Node dummy = new Node(0);
        Node p = dummy;
        while(t != null){
            Node n = t.next.next;
            p.next = t.next;
            //reset the links change during first loop
            t.next = n;
            p = p.next;
            
            t = n;
        }
        
        return dummy.next;
    }
}