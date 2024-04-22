class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> set = new HashSet<>();
        for(String s:deadends){
            set.add(s);
        }
        Set<String> visited = new HashSet<>();
        
        Queue<String> q = new LinkedList<>();
        q.offer(target);
        int steps = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            while(size-- >0){
                String s = q.poll();
                char[] ch = s.toCharArray();
                if(set.contains(s) || visited.contains(s)) continue;
                else if(s.equals("0000")) return steps;
                visited.add(s);
                for(int i = 0; i < 4; i++){
                    int num = ch[i] - '0';
                    if(num != 0){
                        int up = num == 9? 0 : num + 1;
                        int dn = num == 0? 9 : num - 1;
                        ch[i] = (char)(up + '0');
                        q.offer(String.valueOf(ch));
                        ch[i] = (char)(dn + '0');
                        q.offer(String.valueOf(ch));
                        //reset the char[i]
                        ch[i] = (char)(num + '0');
                    }        
                }
             }
            steps++;
            
        }
        return -1;
    }
}