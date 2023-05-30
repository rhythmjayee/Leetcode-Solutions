class MyHashSet {
    int capacity = 32, cnt = 0;
        MyList[] list = new MyList[capacity];;
        /** Initialize your data structure here. */
        public MyHashSet() {
            for(int i=0; i<capacity; i++){
                list[i] = new MyList();
            }
        }

        public void add(int key) {
            if(contains(key)) return;
            if(cnt<capacity){
                addTail(key);
            }else{// rehash
                this.capacity = capacity * 2;
                MyList[] copy = list;
                MyList[] newList = new MyList[capacity];
                for(int i=0; i<capacity; i++){
                    newList[i] = new MyList();
                }
                list = newList;
                for(int i=0; i<copy.length; i++){
                    ListNode head = copy[i].head;
                    while(head.next!=null && head.next.val!=null){
                        addTail(head.next.val);
                        head = head.next;
                    }
                }  
                addTail(key);
            }
            cnt++;
        }

        public void remove(int key) {
            if(!contains(key)) return;
            cnt--;
            int idx = key % capacity;
            ListNode head = list[idx].head;
            while(head.next!=null && head.next.val!=null){
                if(head.next.val==key){
                    ListNode next = head.next;
                    next.next.pre = head;
                    head.next = next.next;
                    next.pre = null;
                    next.next = null;
                    break;
                }
                head = head.next;
            }
        }

        /** Returns true if this set contains the specified element */
        public boolean contains(int key) {
            int idx = key % capacity;
            ListNode head = list[idx].head;
            while(head.next!=null && head.next.val!=null){
                if(head.next.val==key) return true;
                head = head.next;
            }
            return false;
        }

        private void addTail(int key){
            int idx = key % capacity;
            ListNode tail = list[idx].tail;
            ListNode pre = tail.pre;
            ListNode cur = new ListNode(key);
            pre.next = cur;
            cur.pre = pre;
            cur.next = tail;
            tail.pre = cur;
        }
    }
    class MyList{
        public ListNode head;
        public ListNode tail;
        public MyList(){
            head = new ListNode();
            tail = new ListNode();
            head.next = tail;
            tail.pre = head;
        }
    }
    class ListNode{
        public Integer val;
        public ListNode next;
        public ListNode pre;
        public ListNode(){

        }
        public ListNode(int val){
            this.val = val;
        }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */