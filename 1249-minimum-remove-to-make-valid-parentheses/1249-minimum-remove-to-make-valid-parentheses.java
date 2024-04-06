class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder sb = new StringBuilder();
        int openPlaced = 0;
        int openTotal = 0;
        int closeTotal = 0;
        
        for(char c : s.toCharArray()) {
            if(c == '(') openTotal++;
            //only count valid ) from start
            else if(c == ')' && openTotal > closeTotal) closeTotal++;
        }
        for(char c : s.toCharArray()) {
            if(c == '(' && closeTotal > 0) {//atmax we can only add ( of count close
                sb.append(c);
                closeTotal--;
                openPlaced++;
            }//atmax we can only add ) of count openPlaced
            else if(c == ')' && openPlaced > 0) {
                sb.append(c);
                openPlaced--;
            } else if(Character.isLetter(c)) {
                sb.append(c);
            }
        }
        return sb.toString();
    }
}