class Solution {
    public boolean checkIfPangram(String s) {
        if(s.length() < 26) return false;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<s.length(); i++) {
            set.add(s.charAt(i) - 'a');
        }
        return set.size() == 26;
    }
}