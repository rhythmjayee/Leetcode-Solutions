class Solution {
    public int addDigits(int num) {
        if(num/10 == 0) return num;
        
        int sum = 0;
        for(char x :String.valueOf(num).toCharArray()) sum += x-'0';
        
        return addDigits(sum);
    }
}