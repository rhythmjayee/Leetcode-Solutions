class Solution {
    public String makeGood(String s) {
        int i = 0;
        int n = s.length();
        StringBuilder sb = new StringBuilder();
        
        Deque<Character> sk = new LinkedList<>();
        while(i < n) {
            int prev = sk.isEmpty() ? 0 : (int)(sk.getLast());
            int curr = (int)(s.charAt(i));
            int diff = Math.abs(prev - curr);
            if(prev == 0 || diff != 32) {
                sk.addLast(s.charAt(i));
            }else {
                sk.removeLast();
            }
            i++;
        }
        
        while(!sk.isEmpty()) {
            sb.append(sk.removeFirst());
        }
        
        return sb.toString();
    }
}