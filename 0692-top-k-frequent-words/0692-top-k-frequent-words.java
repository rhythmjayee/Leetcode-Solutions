class Solution {
    static class TrieNode {
        String word;
        TrieNode[] next;
        TrieNode() {
            next = new TrieNode[26];
        }
    }
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        int maxFreq = 0;
        for(String s : words) {
            freq.put(s, freq.getOrDefault(s, 0) + 1);
            maxFreq = Math.max(maxFreq, freq.get(s));
        }
        
        //bucket sort -> Add same freq strings under same Trie
        TrieNode count[] = new TrieNode[maxFreq + 1];
        for(String s : freq.keySet()) {
            int f = freq.get(s);
            if(count[f] == null) {
                count[f] = new TrieNode();
            }
            addWord(count[f], s);
        }
        
        List<String> ans = new ArrayList<>();
        //get Words with maxfreq first till size k
        //as we will be getting characters in lexicographical order
        //we will get strings in lexicographical order
        for(int i = maxFreq; i > 0 && ans.size() < k; i--) {
            if(count[i] != null) {
                getWord(count[i], k, ans);
            }
        }
        
        return ans;
    }
    private void addWord(TrieNode root, String s) {
        int n = s.length();
        for(int i = 0; i<n; i++) {
            char c = s.charAt(i);
            if(root.next[c - 'a'] == null) {
                root.next[c - 'a'] = new TrieNode();
            }
            root = root.next[c - 'a'];
        }
        root.word = s;
    } 
    
    private void getWord(TrieNode root, int k, List<String> ans) {
        if(root.word != null) {
            ans.add(root.word);
        }
        
        for(int i = 0; i<26 && ans.size() < k; i++) {
            if(root.next[i] != null) {
                getWord(root.next[i], k, ans);
            }
        }
    }
}