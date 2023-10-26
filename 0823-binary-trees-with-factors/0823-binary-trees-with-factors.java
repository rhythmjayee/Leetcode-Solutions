class Solution {
    public int numFactoredBinaryTrees(int[] arr) {
         if(arr == null ||arr.length ==0){
            return 0;
        }
        int mod = (int)(1e9+7);
        //as leaves are smaller nos & their multiplication results in parent node
        Arrays.sort(arr); // O(nlogn)

        //stores no. of ways to forming a BT with ith node as a parent
        Map<Integer, Long> map = new HashMap<>();
        long totalCount = 0l;
        
        //take each no. (ith) as a parent and
        //for each smaller no. which may be a potential leaf node (jth)
        for(int i = 0; i < arr.length; i++){ // O(n2)
            long count = 1l;
            for(int j = 0; j < i; j++){
                int child1 = arr[j];
                int child2 = arr[i]/arr[j];
                if(arr[i] % child1 == 0 && map.containsKey(child2)){
                    //there may be (n) number of BT with child1 as parent
                    //there may be (m) number of BT with child2 as parent
                    //these 2 make the leaf nodes of arr[i]
                    count += map.get(child1) * map.get(child2);
                }
            }
            //save total count for arr[i]
            map.put(arr[i], count);
            totalCount += map.get(arr[i]);
        }

        return (int)(totalCount % mod);
    }
}