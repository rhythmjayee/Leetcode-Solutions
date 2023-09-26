class Solution {
    public String removeDuplicateLetters(String s) {
        int lastIndex[] = new int[26];
        boolean[] visited = new boolean[26];
        Deque<Integer> sk = new LinkedList<>();

        for(int i = 0;i<s.length();i++){
            lastIndex[s.charAt(i)-'a'] = i;
        }

        for(int i = 0;i < s.length(); i++){
            int index = s.charAt(i)-'a';

            if(visited[index]) continue;
            
            //check if sk's top has greater character & greater character also occured later
            while(!sk.isEmpty() && sk.getLast() > index && lastIndex[sk.getLast()]>i){
              visited[sk.removeLast()] = false;
            }
            
            sk.addLast(index);
            visited[index] = true;
        }

          StringBuilder sb = new StringBuilder();
          while(!sk.isEmpty()){
            sb.append((char)(sk.removeFirst()+'a'));
          }

          return sb.toString();
     
    }
}