class Solution {

    // Ternary search trie node
    static class TstNode {
        String word;
        char ch;
        TstNode left, mid, right;
    }

    // Add word to tst
    private TstNode addWord(TstNode node, String word) {
        return addWord(node, word, 0);
    }

    private TstNode addWord(TstNode node, String word, int i) {
        char ch = word.charAt(i);
        if (node == null) {
            node = new TstNode();
            node.ch = ch;
        }
        if (ch < node.ch) {
            node.left = addWord(node.left, word, i);
        } else if (ch > node.ch) {
            node.right = addWord(node.right, word, i);
        } else if (i < word.length() - 1) {
            node.mid = addWord(node.mid, word, i + 1);
        } else {
            node.word = word;
        }
        return node;
    }

    // Get words from tst node to result
    private void getWords(TstNode node, int k, List<String> result) {
        if (node == null || k == result.size()) {
            return;
        }
        // Search left children first since they have lower alphabetic orders
        getWords(node.left, k, result);
        if (node.word != null) {
            result.add(node.word);
        }
        getWords(node.mid, k, result);
        getWords(node.right, k, result);
    }

    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        if (words == null || words.length == 0) {
            return result;
        }

        // Get frequency of each word
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (String word : words) {
            freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
        }

        // Build buckets
        TstNode[] buckets = new TstNode[words.length + 1];
        for (Map.Entry<String, Integer> entry : freqMap.entrySet()) {
            int freq = entry.getValue();
            buckets[freq] = addWord(buckets[freq], entry.getKey());
        }

        for (int freq = buckets.length - 1; freq > 0 && result.size() < k; freq--) {
            if (buckets[freq] != null) {
                getWords(buckets[freq], k, result);
            }
        }
        return result;
    }
}