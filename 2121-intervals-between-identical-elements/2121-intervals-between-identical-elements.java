class Solution {
    public long[] getDistances(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        long[] res = new long[arr.length];
        for (int i = 0; i < arr.length; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        for (int key : map.keySet()) {
            //get all indeces with same key
            List<Integer> indexes = map.get(key);
            long sum = 0, pre = 0;
            //total sum of indeces
            for (int num : indexes) sum += num;
            //a1, a2, a3 ... ak .... an-2, an-1 an
            //for each index calc left, right sum
            //left -> all values of index are smaller
            //left = (number of smaller indeces * ith value index) - (sum for all smaller indeces)
            //right -> all values of index are larger
            //right = (sum for all larger indeces) - (ith index value * number of larger indeces)
            for (int i = 0; i < indexes.size(); i++) {
                int num = indexes.get(i);
                long left = i * (long)num - pre, right = (sum - pre - num) - (indexes.size() - i - 1) * (long)num;
                res[num] = left + right;
                pre += num;
            }
        }
        return res; 
    }
}