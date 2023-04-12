class Solution {
    public String simplifyPath(String path) {
        String[] pt = path.split("/");
        Deque<String> sk = new LinkedList<>();
        
        for(int i = 0; i<pt.length; i++){
            String s = pt[i];

            if(s.length() == 0 || s.equals(".")) continue;
            if(s.equals("..") && !sk.isEmpty()){
                sk.removeLast();
            }
            else if(!s.equals("..")){
                sk.addLast(s);
            }
            // System.out.println(s);
        }
        StringBuilder sb = new StringBuilder();
        while(!sk.isEmpty()){
            sb.append("/");
            sb.append(sk.removeFirst());

        }
        String ans = sb.toString();
        if(ans.length() == 0) ans = "/";
        return ans;
    }
}