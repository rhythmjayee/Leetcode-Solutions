class Solution {
    public int maxVowels(String s, int k) {
        int max = 0;
        int count = 0;
        int start = 0;
        int n = s.length();
        
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        
        for(int end = 0; end < n; end++) {
            char c = s.charAt(end);
            if(set.contains(c)) count++;
            
            if(end - start == k - 1) {
                max = Math.max(max, count);
                if(set.contains(s.charAt(start++))) {
                    count--;
                }
            }
        }
        return max;
    }
}