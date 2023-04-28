class Solution {
    int[] p;
    int[] sz;
    int n;
    public int find(int i) {
        if(p[i] == i) return i;
        return p[i] = find(p[i]);
    }
    public void union(int i, int j) {
        int pi = find(i);
        int pj = find(j);
        if(pi != pj) {
            n--;
            if(sz[pi] >= sz[pj]) {
                sz[pi] += sz[pj];
                p[pj] = p[pi];
            }else {
                sz[pj] += sz[pi];
                p[pi] = p[pj];
            }
        }
    }
    public boolean isSmiliar(String s1, String s2) {
        if(s1.equals(s2)) return true;
        int count = 0;
        int i = -1;
        int j = -1;
        boolean ans = true;
        for(int k = 0; k<s1.length(); k++) {
            if(s1.charAt(k) != s2.charAt(k) ) {
                count++;
                if(count > 2) {
                    ans = false;
                    break;
                }
                else if(i == -1) i = k;
                else if(j == -1) j = k;
            }
        }
        ans = ans && (s1.charAt(i) == s2.charAt(j) && s1.charAt(j) == s2.charAt(i));
        // System.out.println(s1+" "+s2+" "+ans);
        return ans;
    }
    public int numSimilarGroups(String[] strs) {
        n = strs.length;
        p = new int[n];
        sz = new int[n];
        int m = strs.length;
        for(int i = 0; i<n; i++) {
            p[i] = i;
            sz[i] = 1;
        }
        
        for(int i = 0; i < m; i++) {
            for(int j = i + 1; j < m; j++) {
                if(isSmiliar(strs[i], strs[j])) {
                    union(i, j);
                }
            }
        }
        return n;
    }
}