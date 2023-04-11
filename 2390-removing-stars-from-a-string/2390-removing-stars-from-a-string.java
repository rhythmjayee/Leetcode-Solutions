class Solution {
    public String removeStars(String s) {
        Deque<Character> sk = new LinkedList<>();
        for(char c : s.toCharArray()) {
            if(c == '*') {
                if(!sk.isEmpty()) {
                    sk.removeLast();
                }
            } else {
                sk.addLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!sk.isEmpty()) {
            sb.append(sk.removeFirst());
        }
        return sb.toString();
    }
}