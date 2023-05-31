class TimeStamp {
    String station;
    int travelStart;
    public TimeStamp(String station, int travelStart) {
        this.travelStart = travelStart;
        this.station = station;
    }
}
class UndergroundSystem {
    Map<Integer, TimeStamp> checkInMap;
    Map<String, int[]> avgTimeMap;
    public UndergroundSystem() {
        checkInMap = new HashMap<>();
        avgTimeMap = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new TimeStamp(stationName, t));
    }
    
    public void checkOut(int id, String stationName, int t) {
        TimeStamp ts = checkInMap.get(id);
        checkInMap.remove(id);
        String route = ts.station + "-" + stationName;
        int time = t - ts.travelStart;
        
        avgTimeMap.putIfAbsent(route, new int[]{0, 0});
        int[] avg = avgTimeMap.get(route);
        avg[0] += 1;
        avg[1] += time;
        
    }
    
    public double getAverageTime(String startStation, String endStation) {
        String route = startStation + "-" + endStation;
        int[] avg = avgTimeMap.get(route);
        
        return  (double) avg[1] / avg[0];
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */