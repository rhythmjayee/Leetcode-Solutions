class Solution {
    public String removeDuplicates(String s) {
        Deque<Character> sk = new ArrayDeque<>();
        for(char ch : s.toCharArray()){
            if(!sk.isEmpty() && sk.getLast() == ch) sk.removeLast();
            else sk.addLast(ch);
        }
        StringBuilder sb = new StringBuilder();
        while(!sk.isEmpty()){
            sb.append(sk.removeLast());
        }
        return sb.reverse().toString();
    }
}