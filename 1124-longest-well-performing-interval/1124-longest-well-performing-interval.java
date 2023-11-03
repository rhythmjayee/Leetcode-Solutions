class Solution {
    public int longestWPI(int[] hours) {
        int res = 0, score = 0, n = hours.length;
        Map<Integer, Integer> seen = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            score += hours[i] > 8 ? 1 : -1;
            if (score > 0) {
                res = i + 1;//if > 0, means well-performing interval
            } else {
                //put first occurance of score only to make interval longest
                seen.putIfAbsent(score, i);
                //find score - 1, on removing this part from interval
                //our current score in new interval will be 1 > 0
                if (seen.containsKey(score - 1))
                    res = Math.max(res, i - seen.get(score - 1));
            }
        }
        return res;
    }
}