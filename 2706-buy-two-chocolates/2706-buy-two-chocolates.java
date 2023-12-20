class Solution {
    public int buyChoco(int[] prices, int money) {
        int leftOver = money;
        int smallest = Integer.MAX_VALUE;
        int secondSmallest = Integer.MAX_VALUE;
        
        for(int x : prices) {
            if(x <= smallest) {
                secondSmallest = smallest;
                smallest = x;
            } else if(x < secondSmallest) {
                secondSmallest = x;
            }
        }
        int sum = secondSmallest + smallest;
        return sum > money ? money : money - sum;
    }
}