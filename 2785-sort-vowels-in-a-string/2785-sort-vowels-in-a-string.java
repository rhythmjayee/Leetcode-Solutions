class Solution {
    public String sortVowels(String s) {
        List<Character> ls = Arrays.asList('a', 'A', 'e', 'E', 'i', 'I', 'o', 'O', 'u', 'U');
        Set<Character> set = new HashSet<>();
        set.addAll(ls);
        
        int[] f = new int[256];
        char[] ch = new char[s.length()];
        
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(set.contains(c)) {
                f[(int)(c)]++;
                ch[i] = '0';
            } else {
                ch[i] = c;
            }
        }
        
        int j = 0;
        int k = 0;
        while(k < s.length()) {
            if(ch[k] == '0') {
                while(j < 256 && f[j] == 0) j++;
                ch[k] = (char)(j);
                f[j]--;
            }
            k++;
        }
        return String.valueOf(ch);
    }
}