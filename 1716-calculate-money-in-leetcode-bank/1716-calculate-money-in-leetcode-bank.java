class Solution {
    public int totalMoney(int n) {
        int[] money = new int[7];
        for(int i = 0; i < 7; i++) {
            money[i] = i + 1;
        }
        int sum = 0;
        int i = 0;
        while(i < n) {
            sum += money[i % 7];
            money[i % 7]++;
            i++;
        }
        return sum;
    }
}