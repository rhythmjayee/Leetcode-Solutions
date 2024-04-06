class Solution {
    public String minRemoveToMakeValid(String s) {
        Deque<Integer> sk = new LinkedList<>();//stores ( index
        List<Integer> ls = new ArrayList<>();//stores ) index 
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                sk.addLast(i);
            }else if(c == ')' && !sk.isEmpty()){
                sk.removeLast();
            }else if(c == ')'){
                ls.add(i);
            }
        }
        StringBuilder sb = new StringBuilder();
        int j = 0;
        for(int i = 0; i<s.length(); i++){
            char c = s.charAt(i);
            if(!sk.isEmpty() && sk.getFirst() == i){//for removing extra (
                sk.removeFirst();
            }else if(j < ls.size() && ls.get(j) == i){//for removing extra )
                j++;
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
        
    }
}