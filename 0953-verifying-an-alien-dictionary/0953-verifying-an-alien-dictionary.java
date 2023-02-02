class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i<order.length(); i++) {
            map.put(order.charAt(i), i);
        }
        
        int n = words.length;
        for(int i = 0; i < n - 1; i++) {
            for(int j = i + 1; j < n; j++) {
                int min = Math.min(words[i].length() , words[j].length());
                int f = 0;
                for(int k = 0; k < min; k++) {
                    if(words[i].charAt(k) != words[j].charAt(k)) {
                        if(map.get(words[i].charAt(k)) < map.get(words[j].charAt(k))) {
                            f = 1;
                            break;
                        }
                        else return false;
                    }
                }
                if(f == 0 && words[i].length() > words[j].length()) return false;
            }
        }
        return true;
    }
}