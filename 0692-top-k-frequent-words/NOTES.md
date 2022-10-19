**Trie+ Bucket Sort Based Solution**
We can solve this problem with the similar idea:
Firstly, we need to calculate the frequency of each word and store the result in a hashmap.
​
Secondly, we will use bucket sort to store words. Why? Because the minimum frequency is greater than or equal to 1 and the maximum frequency is less than or equal to the length of the input string array.
​
Thirdly, we can define a trie within each bucket to store all the words with the same frequency. With Trie, it ensures that the lower alphabetical word will be met first, saving the trouble to sort the words within the bucket.
​
From the above analysis, we can see the time complexity is O(n).
```
class Solution {
public List<String> topKFrequent(String[] words, int k) {
HashMap<String,Integer> freq=new HashMap<>();
for(String s:words){
freq.put(s,freq.getOrDefault(s,0)+1);
}
TrieNode[] count=new TrieNode[words.length+1];
for(String word:freq.keySet()){
int c=freq.get(word);
if(count[c]==null){
count[c]=new TrieNode();
}
addWord(word,count[c],0);
}
List<String> ls=new ArrayList<>();
for(int i=count.length-1;i>=1 && ls.size()<k;i--){
getWords(ls,count[i],k);
}
return ls;
}
public void addWord(String word,TrieNode root,int i){
TrieNode curr=root;
for(char c : word.toCharArray()) {
if(curr.children[c - 'a'] == null) {
curr.children[c - 'a'] = new TrieNode();
}
curr = curr.children[c - 'a'];
}
curr.word = word;
}
public void getWords(List<String> ls,TrieNode root,int k){
if(root==null) return;
if(root.word!=null){
TrieNode(){