class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> sk = new LinkedList<>();
        for(int x : asteroids) {
            if(sk.isEmpty() || x > 0) {
                sk.addLast(x);
                continue;
            }
            boolean isDestroyed = false;
            while(!sk.isEmpty() && sk.getLast() > 0 && x < 0) {
                int prev = sk.getLast();
                if(Math.abs(prev) < Math.abs(x)) {
                    sk.removeLast();
                } else if(Math.abs(x) < Math.abs(prev)) {
                    isDestroyed = true;
                    break;
                } else {
                    sk.removeLast();
                    isDestroyed = true;
                    break;
                }
            }
            if(!isDestroyed) sk.addLast(x);
        }
        
        int idx = 0;
        int[] ans = new int[sk.size()];
        while(!sk.isEmpty()) {
            ans[idx++] = sk.removeFirst();
        }
        return ans;
    }
}