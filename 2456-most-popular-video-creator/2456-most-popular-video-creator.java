class Solution {
    static class Stats {
        int views;
        Map<String, Integer> videos;
        Stats() {
            views = 0;
            videos = new HashMap<>();
        }
    }
    public List<List<String>> mostPopularCreator(String[] creators, String[] ids, int[] views) {
        Map<String, Stats> map = new HashMap<>();
        int n = ids.length;
        
        for(int i = 0; i<n; i++) {
            map.putIfAbsent(creators[i], new Stats());
            var st = map.get(creators[i]);
            st.views += views[i];
            st.videos.put(ids[i], views[i]);
        }
        
        List<Map.Entry<String, Stats>> ls = new ArrayList<>();
        ls.addAll(map.entrySet());
        //O(5log5)
        Collections.sort(ls, (a, b) -> {
            return b.getValue().views - a.getValue().views;
        });
        
        int max = ls.get(0).getValue().views;
        List<List<String>> ans = new ArrayList<>();
        for(int i = 0; i<ls.size(); i++) {
            String c = ls.get(i).getKey();
            int v = ls.get(i).getValue().views;
            Map<String, Integer> cVideos = ls.get(i).getValue().videos;
            if(v == max) {
                 List<Map.Entry<String, Integer>> sorted = new ArrayList<>();
                 sorted.addAll(cVideos.entrySet());
                //O(nlogn)
                Collections.sort(sorted, (a, b) -> {
                    if(a.getValue() != b.getValue()) return b.getValue() - a.getValue();
                    return a.getKey().compareTo(b.getKey());
                });
                List<String> ann = new ArrayList<>();
                ann.add(c);
                ann.add(sorted.get(0).getKey());
                ans.add(ann);
            }else break;
        }
        
        return ans;
    }
}