class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Deque<Integer> sk = new LinkedList<>();
        int i = 0;
        for(int x : pushed) {
            sk.addLast(x);
            while(!sk.isEmpty() && sk.getLast() == popped[i]) {
                sk.removeLast();
                i++;
            }
        }
        return sk.isEmpty() && i == popped.length;
    }
}