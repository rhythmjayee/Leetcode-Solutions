class Solution {
 public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
		List<List<Integer>> res = new ArrayList<>();
		if (nums1.length == 0 || nums2.length == 0 || k == 0) return res;
		// Using lambda function to pass list as element to pq, while maintaining as minHeap
        //[i, j]
		PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> {
            return (nums1[a[0]] + nums2[a[1]]) - (nums1[b[0]] + nums2[b[1]]);
        });
        //[i, 0] [i+1, 0] ... [i+k, 0]
		for (int i = 0; i < nums1.length && i < k; i++) {
			// add pair of idexes of nums1 -> i & nums2 - > 0, till pq size is not k
			pq.offer(new int[]{i, 0});
		}

		while (!pq.isEmpty() && k-- > 0) {
            //top pair will have lowest sum
			int[] cur = pq.poll(); 
			List<Integer> list = new ArrayList<>();
			list.add(nums1[cur[0]]);
			list.add(nums2[cur[1]]);
			res.add(list);
            //check if all elements of nums2 is paired with nums1's cur element
			if (cur[1] + 1 == nums2.length) continue;
			pq.offer(new int[]{cur[0], cur[1] + 1});

		}
		return res;
	}
}