class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int i = 0;//holds starts of words in a single line
        int j = 0;//pointer to move over the words
        int n = words.length;
        List<String> ans = new ArrayList<>();
        while(i < n) {
            List<String> line = new ArrayList<>();
            int count = 0;//count the chrs + single space bw chrs for single line 
            while(j < n) {
                if(count + words[j].length() > maxWidth) break;
                else if(count + words[j].length() + 1 <= maxWidth) count++;
                count += words[j].length();
                line.add(words[j]);
                j++;
            }
            String justifiedLine = createLine(line, j, words, maxWidth);
            ans.add(justifiedLine);
            i = j;
        }
        return ans;
    }
    private String createLine(List<String> line, int i, String[] words, int maxWidth) {
        int baseLength = -1;
        for (String word: line) {
            baseLength += word.length() + 1;
        }

        int extraSpaces = maxWidth - baseLength;

        if (line.size() == 1 || i == words.length) {
            return String.join(" ", line) + " ".repeat(extraSpaces);
        }

        int wordCount = line.size() - 1;
        int spacesPerWord = extraSpaces / wordCount;
        int needsExtraSpace = extraSpaces % wordCount;

        for (int j = 0; j < needsExtraSpace; j++) {
            line.set(j, line.get(j) + " ");
        }

        for (int j = 0; j < wordCount; j++) {
            line.set(j, line.get(j) + " ".repeat(spacesPerWord));
        }

        return String.join(" ",  line);
    }
}