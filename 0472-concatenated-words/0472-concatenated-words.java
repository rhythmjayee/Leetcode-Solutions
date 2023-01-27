class Solution {
    private boolean dfs(final String word, int length, final boolean[] visited, final Set<String> dictionary) {
        if (length == word.length()) {
            return true;
        }
        if (visited[length]) {
            return false;
        }
        visited[length] = true;
        //To make sure we consider atleast 2 words
        //for length == 0
        for (int i = word.length() - (length == 0 ? 1 : 0); i > length; --i) {
            //choose prefix starting from length to i-1
            //try to check for rest of the string in word from i
            if (dictionary.contains(word.substring(length, i)) 
                && dfs(word, i, visited, dictionary)) {
                return true;
            }
            
        }
        return false;
    }
    
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        final Set<String> dictionary = new HashSet<>(Arrays.asList(words));
        final List<String> answer = new ArrayList<>();
        //take every word and check if its a valid word acc. to Qu
        for (final String word : words) {
            final int length = word.length();
            final boolean[] visited = new boolean[length];
            if (dfs(word, 0, visited, dictionary)) {
                answer.add(word);
            }
        }
        return answer;   
    }
}