class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.length() == 0) return new ArrayList<>();
        
        Map<Integer,char[]> map = new HashMap<>();
        map.put(2,new char[]{'a','b','c'});
        map.put(3,new char[]{'d','e','f'});
        map.put(4,new char[]{'g','h','i'});
        map.put(5,new char[]{'j','k','l'});
        map.put(6,new char[]{'m','n','o'});
        map.put(7,new char[]{'p','q','r','s'});
        map.put(8,new char[]{'t','u','v'});
        map.put(9,new char[]{'w','x','y','z'});
        
        List<String> res = get(digits, 0, map);
        return res;
    }
    private List<String> get(String digit, int i, Map<Integer,char[]> map){
        if(i == digit.length()){
            List<String> res = new ArrayList<>();
            res.add("");
            return res;
        }
        
        int d = digit.charAt(i) - '0';
        List<String> newRes = new ArrayList<>();
        
        List<String> restDigit = get(digit, i+1, map);
            
        for(char c : map.get(d)){
            for(String st : restDigit){
                StringBuilder sb = new StringBuilder(c+"");
                sb.append(st);
                newRes.add(sb.toString());
            }
        }
        
        return newRes;
    }
}