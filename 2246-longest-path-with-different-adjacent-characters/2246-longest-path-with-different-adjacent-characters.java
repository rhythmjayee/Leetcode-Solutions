class Solution {
    int max = 1;
    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        List<List<Integer>> g = new ArrayList<>();
        for(int i = 0; i<n; i++) {
            g.add(new ArrayList<>());            
        }
        for(int i = 1; i<n; i++) {
            g.get(parent[i]).add(i);
        }
        dfs(g, 0, s);
        return max;
    }
    private int dfs(List<List<Integer>> g, int node, String s) {
        char c = s.charAt(node);
        int largestLen = 0;
        int secondLargestLen = 0;
        int otherLen = 0;
        for(int x : g.get(node)) {
            if(s.charAt(x) != c) {
                int len = dfs(g, x, s);
                if(len > largestLen) {
                    secondLargestLen = largestLen;
                    largestLen = len;
                }else if(len > secondLargestLen) {
                    secondLargestLen = len;
                }
            } else {
                //get largest len, when char same as next node
                otherLen = Math.max(otherLen, dfs(g, x, s));
            }
        }
        //+1 in len for curr node
        int mmx = Math.max(largestLen + secondLargestLen + 1, otherLen);
        max = Math.max(max, mmx);
        //reutrn largest length to parent
        return largestLen + 1;
    }
}