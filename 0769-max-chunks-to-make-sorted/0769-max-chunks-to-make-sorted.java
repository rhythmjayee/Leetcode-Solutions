class Solution {
    public int maxChunksToSorted(int[] arr) {
        int max = 0;
        int count = 0;
        for(int i = 0; i < arr.length; i++) {
            int x = arr[i];
            max = Math.max(max, x);
            if(max == i) count++;
            //if max is same as the original position in sorted arr then can be chuncked
        }
        return count;
    }
}