class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return dfs(0, rooms, new HashSet<>(), new int[rooms.size()]);
    }
    private boolean dfs(int room, List<List<Integer>> rooms, Set<Integer> keys, int[] v) {
        keys.add(room);
        v[room] = 1;
        
        if(keys.size() == rooms.size()) return true;
        
        for(int nextRoom : rooms.get(room)) {
            if(v[nextRoom] == 0) {
                if(dfs(nextRoom, rooms, keys, v)) return true;
            }
        }
        return false;
    }
}