class Solution {
    static class TrieNode {
        String word;
        TrieNode[] next;
        TrieNode() {
            word = null;
            next = new TrieNode[26];
        }
    }
    static int[][] dirs = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
    public List<String> findWords(char[][] b, String[] w) {
        TrieNode root = new TrieNode();
        addWords(w, root);
        
        List<String> ans = new ArrayList<>();
        int n = b.length;
        int m = b[0].length;
        
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++) {
                getWords(b, i, j, root.next[b[i][j] - 'a'], ans);
            }
        }
        return ans;
    }
    private void getWords(char[][] b, int i, int j, TrieNode root, List<String> ans) {
        char c = b[i][j];
        if(root == null) return;
        else if(root.word != null) {
            ans.add(root.word);
            root.word = null;
        }

        b[i][j] = '0';
        for(int[] d : dirs) {
            int x = d[0] + i;
            int y = d[1] + j;
            
            if(x < 0 || y < 0 || x >= b.length || y >= b[0].length || b[x][y] == '0') {
                continue;
            }
            getWords(b, x, y, root.next[b[x][y] - 'a'], ans);
        }
        b[i][j] = c;
    }
    private void addWords(String[] w, TrieNode root) {
        for(String s : w) {
            TrieNode cur = root;
            for(int i = 0; i<s.length(); i++) {
                char c = s.charAt(i);
                if(cur.next[c - 'a'] == null) {
                    cur.next[c - 'a'] = new TrieNode();
                }
                cur = cur.next[c - 'a'];
            }
            cur.word = s;
        }
    }
}