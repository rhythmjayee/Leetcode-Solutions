class Solution {
    Map<Integer, List<String>> dp = new HashMap<>();
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> words = new HashSet<>();
        for(String st: wordDict) words.add(st);
        
        return dfs(s, 0, words);
    }
    private List<String> dfs(String s, int i, Set<String> words) {
        List<String> newList = new ArrayList<>();
        if(i == s.length()) {
            newList.add("");
            return newList;
        }
        else if(dp.containsKey(i)) return dp.get(i); 
        
        
        for(int j = i; j < s.length(); j++) {
            String sub = s.substring(i, j + 1);
            // System.out.println(i+" "+sub+" "+(j + 1)+" ----");
            if(words.contains(sub)) {
                List<String> res = dfs(s, j + 1, words);
                // System.out.println(i+" "+ res +"====");
                for(String strInRes: res) {
                    String subWithRes = (sub+" "+strInRes).trim();
                    newList.add(subWithRes);
                }
            }
        }
        dp.put(i, newList);
        return newList;
    }
}