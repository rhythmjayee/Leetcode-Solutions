class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> sk = new LinkedList<>();
        for(String x : tokens) {
            if(x.equals("+")) {
                int a = sk.removeLast();
                int b = sk.removeLast();
                sk.addLast((a+b));
            }else if(x.equals("-")) {
                int a = sk.removeLast();
                int b = sk.removeLast();
                sk.addLast((b-a));
            }else if(x.equals("*")) {
                int a = sk.removeLast();
                int b = sk.removeLast();
                sk.addLast((b*a));
            }else if(x.equals("/")) {
                int a = sk.removeLast();
                int b = sk.removeLast();
                sk.addLast((b/a));
            }else {
                sk.addLast(Integer.valueOf(x));
            }
        }
        return sk.removeLast();
    }
}