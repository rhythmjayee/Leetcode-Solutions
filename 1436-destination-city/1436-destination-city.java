class Solution {
    public String destCity(List<List<String>> paths) {
        Map<String, Integer> outGoingMap = new HashMap<>();
        for(List<String> p : paths) {
            outGoingMap.putIfAbsent(p.get(0), 0);
            outGoingMap.putIfAbsent(p.get(1), 0);
            outGoingMap.put(p.get(0), outGoingMap.get(p.get(0)) + 1);
        }
        for(String k : outGoingMap.keySet()) {
            if(outGoingMap.get(k) == 0) return k;
        }
        return "";
    }
}