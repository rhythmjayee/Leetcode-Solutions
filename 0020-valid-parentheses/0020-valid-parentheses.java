class Solution {
    public boolean isValid(String s) {
        Deque<Character> sk = new LinkedList<>();

        for(char c : s.toCharArray()){
            if(c == '(' || c == '{' || c == '[') sk.push(c);
            else{
                if(sk.isEmpty()) return false;
                else if(c == ')' && sk.peek() == '('){
                    sk.pop();
                }
                else if(c == ']' && sk.peek() == '['){
                    sk.pop();
                }
                else if(c == '}' && sk.peek() == '{'){
                    sk.pop();
                }else{
                    return false;
                }
            }
        }
        return sk.isEmpty() ? true : false;
    }
}