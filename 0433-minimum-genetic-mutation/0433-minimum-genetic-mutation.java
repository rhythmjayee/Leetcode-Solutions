class Solution {
    public int minMutation(String start, String end, String[] bank) {
        char[] chrs = {'A', 'C', 'G', 'T'};
        Set<String> set = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        int mutations = 0;
        
        for(String s : bank) {
            set.add(s);
        }
        
        q.add(start);
        while(!q.isEmpty()) {
            int sz = q.size();
            while(sz-- > 0) {
                String gs = q.poll();
                char[] gsc = gs.toCharArray();
                
                for(int i = 0; i<gsc.length; i++) {
                    char prev = gsc[i];
                    for(int j = 0; j<chrs.length; j++) {
                        char nc = chrs[j];
                        if(nc != gsc[i]) {
                            gsc[i] = nc;
                            String newMut = String.valueOf(gsc);
                            if(set.contains(newMut)) {
                                if(newMut.equals(end)) return mutations + 1;
                                q.add(newMut);
                                set.remove(newMut);
                            }
                        }
                    }
                    gsc[i] = prev;
                }
            }
            if(!q.isEmpty()) mutations++;
        }
        
        return -1;
    }
}