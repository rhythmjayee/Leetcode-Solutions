class Solution {
    class Ticket {
        int id;
        String to;
        Ticket(int id, String to) {
            this.id = id;
            this.to = to;
        }
    }
    int idx = 0;
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, List<Ticket>> map = new HashMap<>();
        for(List<String> tk : tickets) {
            map.putIfAbsent(tk.get(0), new ArrayList<>());
            map.get(tk.get(0)).add(new Ticket(idx++, tk.get(1)));
        }
        for(String key : map.keySet()) {
            // System.out.println(key);
            List<Ticket> t = map.get(key);
            // for(Ticket tk : t) System.out.println("--> "+tk.to);
            Collections.sort(t, (a, b) -> a.to.compareTo(b.to));
        }
        List<String> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        ans.add("JFK");
        dfs("JFK", map, ans, set);
        return ans;
    }
    public boolean dfs(String place, Map<String, List<Ticket>> map, List<String> ans, Set<Integer> set) {
        if(set.size() == idx) return true;
        // System.out.println(place);
        for(Ticket tk : map.getOrDefault(place, new ArrayList<>())) {
            // System.out.println(tk.to);
            if(set.contains(tk.id)) continue;
            set.add(tk.id);
            ans.add(tk.to);
            if(dfs(tk.to, map, ans, set)) return true;
            set.remove(tk.id);
            ans.remove(ans.size() - 1);
        }
        return false;
    }
}