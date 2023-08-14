class Solution {
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        return find(nums, n - k, 0, n - 1);
    }
    public int find(int[] nums, int k, int l, int h) {
        int idx = partition(nums, l, h);

        if (idx == k) return nums[k];
        else if (idx > k) return find(nums, k, l, idx - 1);
        return find(nums, k, idx + 1, h);
    }

    public int partition(int[] nums, int l, int h) {
        if (l == h) return l;
        Random rm = new Random();
        int idx = l + rm.nextInt(h - l);

        swap(nums, h, idx);

        int pivot = nums[h];
        for (int i = l; i < h; i++) {
            if (nums[i] < pivot) {
                swap(nums, l++, i); // shifting all smaller elements than pivot to front
            }
        }
        swap(nums, l, h); // putting pivot to its poistion-> all elements in front are smaller
        return l;
    }
    public void swap(int a[], int l, int h) {
        int temp = a[l];
        a[l] = a[h];
        a[h] = temp;
    }
}