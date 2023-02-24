class Solution {
   public int minimumDeviation(int[] nums) {
        PriorityQueue<Pair<Integer, Integer>> minHeap = new PriorityQueue<>((o1, o2) -> o1.getKey() - o2.getKey());
        int maxOddFromEven = 0;//on dividing /2 , max odd num we can get from all even nums
        int result = Integer.MAX_VALUE;

        for (int num : nums) {
            int oddFromEven = num;
            while (oddFromEven % 2 == 0)
                oddFromEven /= 2;

            maxOddFromEven = Math.max(maxOddFromEven, oddFromEven);
            minHeap.add(new Pair<Integer, Integer>(oddFromEven, num));
        }
    
        //initally heap will have pairs like {odd, odd} & {oddFromEven, even}
        while (minHeap.size() == nums.length) {
            var pair = minHeap.poll();
            result = Math.min(result, maxOddFromEven - pair.getKey());

            //we want to hit a condition which dont follows below one
            //so that loop breaks
            if (pair.getKey() % 2 == 1 || pair.getKey() < pair.getValue()) {
                //this condition will try to make a pairs like {evenFormOdd, odd} & {smallerEven, even}
                minHeap.add(new Pair<Integer, Integer>(pair.getKey() * 2, pair.getValue()));
                //update maxOddFromEven
                maxOddFromEven = Math.max(maxOddFromEven, pair.getKey() * 2);
            }
        }

        return result;
    }
}