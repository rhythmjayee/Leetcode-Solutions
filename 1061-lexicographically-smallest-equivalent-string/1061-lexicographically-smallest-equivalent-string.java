class Solution {
    int[] parent;
    //s-e a-o e-o
    private int find(int ch) {
        if(ch == parent[ch]) return ch;
        return parent[ch] = find(parent[ch]);
    }
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        parent = new int[26];
        int n = s1.length();
        int m = baseStr.length();
        
        for(int i = 0; i<26; i++) {
            parent[i] = i;
        }
        
        for(int i = 0 ; i<n; i++) {
            int c1 = s1.charAt(i) - 'a';
            int c2 = s2.charAt(i) - 'a';
            //get parent of both chrs
            int p1 = find(c1);
            int p2 = find(c2);
            
            if(p1 == p2) continue;
            else if(p1 < p2) {//allocate parent which is smaller
                parent[p2] = p1;
            }else {
                parent[p1] = p2;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<m; i++) {
            int c = baseStr.charAt(i) - 'a';
            char ch = (char)(find(c) + 'a');
            sb.append(ch);
        }
        return sb.toString();
    }
}