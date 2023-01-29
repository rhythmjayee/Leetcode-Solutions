class LFUCache {
    Map<Integer,Integer> vals ;//store key, value
    Map<Integer,Integer> counts ;//store key, freq
    Map<Integer,Set<Integer>> countList;//store freq, set<keys>
    
    int min;//min freq
    int cap;
    public LFUCache(int capacity) {
        vals = new HashMap<>();
        counts = new HashMap<>();
        countList = new HashMap<>();
        countList.put(1,new LinkedHashSet<>());
        this.cap = capacity;
        this.min = -1;
    }
    
    public int get(int key) {
        if(!vals.containsKey(key)) return -1;
        
        int count = counts.get(key);//get prev count
        counts.put(key,count+1);//update freq count
        
        countList.get(count).remove(key);//remove from prev count set
        //set new min freq
        if(count == min && countList.get(count).size() == 0){
            min++;
        }
        
        countList.putIfAbsent(count+1, new LinkedHashSet<>());
        
        countList.get(count+1).add(key);
        return vals.get(key);
    }
    
    public void put(int key, int value) {
        if(cap <= 0) return;
        if(vals.containsKey(key)){
            vals.put(key,value);
            get(key);
            return;
        }
        //new key
        if(cap == vals.size()){
            //remove least freq key
            int rm = countList.get(min).iterator().next();
            vals.remove(rm);
            counts.remove(rm);
            countList.get(min).remove(rm);
        }
        this.min = 1;
        vals.put(key,value);
        counts.put(key,min);
        countList.get(min).add(key);
        
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */