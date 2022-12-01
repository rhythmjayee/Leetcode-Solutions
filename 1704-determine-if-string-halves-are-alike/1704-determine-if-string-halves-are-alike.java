class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        List<Character> ch = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        Set<Character> set = new HashSet<>();
        set.addAll(ch);
        int count = 0;
        String a = s.substring(0, n/2);
        int[] f = new int[256];
        for(char c : a.toCharArray()) {
            if(set.contains(c)) {
                count++;
            }
        }
        String b = s.substring(n / 2);
        for(char c : b.toCharArray()) {
            if(set.contains(c)) {
               count--;
            }
        }
        return count == 0;
    }
}