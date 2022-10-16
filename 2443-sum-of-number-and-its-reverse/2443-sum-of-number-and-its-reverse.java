class Solution {
    public boolean sumOfNumberAndReverse(int num) {
        for(int i = 0; i<= num; i++){
            if(i + rev(i) == num) return true;
        }
        
        return false;
    }
    public int rev(int x){
        int newNum = 0;
        while(x > 0){
            int l = x % 10;
            newNum = newNum * 10 + l;
            x /= 10;
        }
        return newNum;
    }
}