class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prevFlower = -1;
        int m = flowerbed.length;
        for(int i = 0; i<m && n>0; i++){
            if(flowerbed[i] == 1) prevFlower = i;
            else if(prevFlower == -1 || i - prevFlower > 1){
                if(i == m-1 || i < m-1 && flowerbed[i+1] != 1){
                    n--;
                    prevFlower = i;
                }
                
            }
        }
        return n == 0;
    }
}