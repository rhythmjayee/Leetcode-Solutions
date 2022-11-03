class Solution {
    public int longestPalindrome(String[] words) {
        /*
        As words has len 2, and we need palindrome
        Main Logic -> 
            1. for all words -> we need its reverse also
            2. words & their reverse can have diff count 
                -> we take min count
                -> cuz min no. of these two will be taken to form Palindrome
            3. Some words some may not have their reverse words
                -> If these words are Palidrome can used as word
            4. Edge Case ->
                -> Some words which are Palindrome may occur many times
                -> For those we take min = min/2 
                -> As count of words & its reverse will be consider 2 times
                -> if min is odd 
                    ->then we can use single of this word as middle word in Palindrome
        */
        
        //calc count of words
        Map<String, Integer> map = new HashMap<>();
        for(String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }
        int count = 0;
        //To skip the words as their reverse word had been processed
        Set<String> v = new HashSet<>();
        //To check for middle word
        int flag = 0;
        for(String w : map.keySet()) {
            String r = new StringBuilder(w).reverse().toString();
            if(!v.contains(r)) {
                //get count of word & reverse word
                int c = map.get(w);
                int rc = map.getOrDefault(r, 0);
                int min = Math.min(c, rc);
                //single word & already Palindrome -> middle word
                if(min == 1 && w.charAt(0) == w.charAt(1)) flag = 1;
                else {
                    //Palindrome words occurs multiple times
                    if(w.charAt(0) == w.charAt(1)) {
                        //for odd count -> one instance can be used as middle word
                        flag = min % 2 == 0 ? flag : 1;
                        //As Palindrome word -> 
                        //count will be counted 2 times for both word & reverse
                        min = min / 2;
                    }
                    //each word is of len 2 & we will add word & revese word
                    count += min*4;
                    v.add(w);
                }
            }
        }
        //if middle word is found, consider its len
        count = flag == 1 ? count + 2 : count;
        return count;
    }
}