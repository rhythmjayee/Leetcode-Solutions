/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return empty list if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    Deque<Integer> sk;
    List<NestedInteger> nestedList;
    int sz;
    int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.sk = new LinkedList<>();
        this.sz = nestedList.size();
        this.index = 0;
        while(this.sk.isEmpty() && this.index < this.sz)
            fillIn(this.nestedList.get(this.index++));
        
    }
    private void fillIn(NestedInteger obj) {
        if(obj.isInteger()) {
            sk.addLast(obj.getInteger());
            return;
        }
        List<NestedInteger> ls = obj.getList();
        for(NestedInteger ni : ls) {
            fillIn(ni);
        }
    }

    @Override
    public Integer next() {
        if(!sk.isEmpty()) return sk.removeFirst();
        
        while(this.sk.isEmpty() && this.index < this.sz)
            fillIn(this.nestedList.get(this.index++));
        
        return sk.removeFirst();
    }

    @Override
    public boolean hasNext() {
        if(!sk.isEmpty()) return true;
        
        while(this.sk.isEmpty() && this.index < this.sz)
            fillIn(this.nestedList.get(this.index++));
        
        return !sk.isEmpty();
    }
}

/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */