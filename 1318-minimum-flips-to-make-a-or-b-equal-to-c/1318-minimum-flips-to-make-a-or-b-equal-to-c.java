class Solution {
    public boolean isBitUp(int a, int i) {
        return ((a & (1 << i)) != 0) ? true : false;
    }
    public int minFlips(int a, int b, int c) {
        int i = 0;
        int count = 0;
        while(i < 32) {
            boolean cBit = isBitUp(c, i);
            boolean aBit = isBitUp(a, i);
            boolean bBit = isBitUp(b, i);
            
            if(cBit && !(aBit || bBit)) {
                count++;
            }else if(!cBit) {
                if(aBit) count++;
                if(bBit) count++;
            }
            // System.out.println(i+" "+cBit+" "+aBit+" "+bBit+" "+count );
            i++;
        }
        return count;
    }
}