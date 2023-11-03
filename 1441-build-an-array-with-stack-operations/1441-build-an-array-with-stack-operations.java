class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> ans = new ArrayList<>();
        Deque<Integer> sk = new LinkedList<>();
        int len = target.length;
        int j = 0;
        for(int i = 1; i<=n; i++) {
            if(j == len) break;
            while((j == 0 && !sk.isEmpty()) || (j > 0 && sk.getLast() != target[j - 1])) {
                sk.removeLast();
                ans.add("Pop");
            }
            sk.addLast(i);
            ans.add("Push");
            if(i == target[j]) j++;
        }
        return ans;
    }
}