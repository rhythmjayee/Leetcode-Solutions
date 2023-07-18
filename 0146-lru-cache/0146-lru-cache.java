class LRUCache {

    static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        Node() {}

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    int capacity;
    int count = 0;
    HashMap < Integer, Node > memory;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        memory = new HashMap < > ();
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
    }
    
    public void addNode(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    public void removeNode(Node node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
        node.next = null;
        node.prev = null;
    }

    public void updateNode(Node node) {
        removeNode(node);
        addNode(node);
    }

    public int get(int key) {
        Node temp = memory.get(key);
        if (temp == null) return -1;
        else {
            updateNode(temp);
            return temp.val;
        }
    }

    public void put(int key, int value) {
        Node temp = memory.get(key);
        if (temp == null) {
            Node node = new Node(key, value);
            memory.put(key, node);
            addNode(node);
            count++;
            if (count > capacity) {
                memory.remove(tail.prev.key);
                removeNode(tail.prev);
                count--;
            }
        } else {
            temp.val = value;
            updateNode(temp);
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */