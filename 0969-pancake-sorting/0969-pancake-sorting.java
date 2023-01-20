class Solution {
    public List<Integer> pancakeSort(int[] arr) {
        //use bubble sort like approach
        //shift the larger values to end first
        List<Integer> ans = new ArrayList<>();
        //Take larger vals first
        for(int i = arr.length; i>0; i--) {
            //if val is already at its right position
            if(arr[i - 1] == i) continue;
            //find the pos of curr target val which need to be placed
            //we need to go till the curr vals as length in arr
            int id = -1;
            for(int j = 0; j < i; j++) {
                if(arr[j] == i) {
                    id = j;
                    break;
                }
            }
            doReverse(arr, id);
            doReverse(arr, i - 1);
            //first move the val to first index -> 0th
            ans.add(id+1);
            //move the val to its right positon
            ans.add(i);
        }
        return ans;
    }
    private void doReverse(int[] arr, int end) {
        int start = 0;
        while(start < end) {
            swap(arr, start++, end--);
        }
    }
    private void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }
}