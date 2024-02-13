class Solution {
    public String firstPalindrome(String[] words) {
        for(String s : words){
            String ns = new StringBuilder(s).reverse().toString();
            if(ns.equals(s)) return s;
        }
        return "";
    }
}