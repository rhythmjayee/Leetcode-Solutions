class Solution {
  public String reverseWords(String s) {
    StringBuilder rev = new StringBuilder();
    int end = 0;
    for (int i = s.length() - 1; i >= 0; --i) {
      if (s.charAt(i) != ' ') {
        end = i;
        i = s.lastIndexOf(' ', end);
        rev.append(s.substring(i + 1, end + 1)).append(' ');
      }
    }
    return rev.toString().trim();
  }
}