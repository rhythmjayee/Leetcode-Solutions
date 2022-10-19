**Trie+ Bucket Sort Based Solution**
We can solve this problem with the similar idea:
Firstly, we need to calculate the frequency of each word and store the result in a hashmap.
​
Secondly, we will use bucket sort to store words. Why? Because the minimum frequency is greater than or equal to 1 and the maximum frequency is less than or equal to the length of the input string array.
​
Thirdly, we can define a trie within each bucket to store all the words with the same frequency. With Trie, it ensures that the lower alphabetical word will be met first, saving the trouble to sort the words within the bucket.
​
From the above analysis, we can see the time complexity is O(n).
​
return ls;