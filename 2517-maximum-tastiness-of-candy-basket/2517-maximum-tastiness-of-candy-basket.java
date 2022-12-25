class Solution {
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int lo = 0, hi = price[price.length - 1] - price[0] + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (check(mid, price, k)) lo = mid + 1;
            else hi = mid;
        }
        return lo - 1;
    }
    boolean check(int x, int[] price, int k) {
        int last = price[0], count = 1, i = 1;
        while (count < k && i < price.length) {
            if (price[i] - last >= x) {
                last = price[i]; count++;
            }
            i++;
        }
        return count == k;
    }
}
//13,5,1,8,21,2
// 1 2 5 8 13 21