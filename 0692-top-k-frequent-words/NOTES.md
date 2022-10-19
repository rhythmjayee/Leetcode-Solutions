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
ls.add(root.word);
}
if(ls.size()==k) return;
TrieNode curr=root;
for(int i=0;i<26;i++){
if(curr.children[i]!=null){
getWords(ls,curr.children[i],k);
}
}
}
}
​
class TrieNode{
String word;
TrieNode[] children;
TrieNode(){
this.word=word;
this.children=new TrieNode[26];
}
}
```