class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int start = 0;
        int maxFruits = 0;
        for(int end = 0; end < fruits.length; end++) {
            map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
            if(map.size() <= 2) {
                maxFruits = Math.max(maxFruits, end - start + 1);
            }else {
                while(start <= end && map.size() > 2) {
                    map.put(fruits[start], map.get(fruits[start]) - 1);
                    if(map.get(fruits[start]) == 0) map.remove(fruits[start]);
                    start++;
                }
                maxFruits = Math.max(maxFruits, end - start + 1);
            }
        }
        return maxFruits;
    }
}