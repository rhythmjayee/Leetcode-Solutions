class Solution {
    public String removeKdigits(String num, int k) {
        Deque<Integer> sk = new LinkedList<>();
        for(char c : num.toCharArray()) {
            int x = c - '0';
            while(!sk.isEmpty() && k > 0 && sk.getLast() > x) {
                sk.removeLast();
                k--;
            }
            sk.addLast(x);
        }
        StringBuilder sb = new StringBuilder();
        while(!sk.isEmpty() && sk.size() != k) {
            int x = sk.removeFirst();
            if(x == 0 && sb.length() == 0) continue;
            sb.append(x);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }
}