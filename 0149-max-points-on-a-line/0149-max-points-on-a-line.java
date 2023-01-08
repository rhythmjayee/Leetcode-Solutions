class Solution {
    public int maxPoints(int[][] points) {
        int n = points.length;
        int max = 0;
        for(int i = 0; i<n; i++) {
            int inf = 0;
            Map<Double, Integer> map = new HashMap<>();
            for(int j = 0; j<n; j++) {
                if(i != j) {
                    double x = points[j][0] - points[i][0];
                    if(x == 0) {
                        inf++;
                         max = Math.max(max, inf);
                        continue;
                    }
                    double y = points[j][1] - points[i][1];
                    double d = y / x;
                    map.put(d, map.getOrDefault(d, 0) + 1);
                    max = Math.max(max, map.get(d));
                }
            }
        }
        return max + 1;
    }
}