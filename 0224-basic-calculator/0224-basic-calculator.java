class Solution {
    public int calculate(String s) {
        Deque<Integer> sk = new LinkedList<>();
        int num = 0;
        int sign = 1;//positive
        int res = 0;
        
        for(char c : s.toCharArray()) {
            int n = c-'0';
            if(n>=0 && n<=9) {//formation of number
                num = num*10+n;
            }else if(c == '+') {
                res += sign*num;//add prev formed number with its sign
                num = 0;//reset num
                sign = 1;//sign will be positive
            }else if(c == '-') {
                res += sign*num;//add prev formed number with its sign
                num = 0;//reset num
                sign = -1;//sign will be negative
            }else if(c == '(') {
                sk.addLast(res);//add res because before ( there must be sign and res will get calculated
                sk.addLast(sign);//sign before (
                res = 0;//reset sign & num
                sign = 1;
                num = 0;
            }else if(c == ')'){
                res += sign*num;//add prev formed number with its sign
                num = 0;//reset num
                res *= sk.removeLast();//add sign
                res += sk.removeLast();//add prev res formed just before (
            }
        }
        
        if(num != 0)  res += sign*num;//add prev formed number with its sign
        return res;
    }
}