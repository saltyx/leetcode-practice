class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (words == null || words.length == 0 || s == null || s.equals("")) {
            return result;
        }
        int len = words[0].length();
        // convert to hashmap
        Map<String, Integer> wordMap = new HashMap<>();
        for (String word : words) {
            if (wordMap.get(word) == null) {
                wordMap.put(word, 1);
            } else {
                wordMap.put(word, wordMap.get(word)+1);
            }
        }

        Map<String, Integer> wordCount = new HashMap<>();

        // 将s字符串切割为长度为len的
        for (int i = 0; i < s.length()-len*(words.length-1); i++) {
            int lastSuccessCount = 0;
            wordCount.clear();
            if ( (s.length()-i) < words.length*len) continue;

            for (int j=0; j<words.length; ++j) {
                String cur = s.substring(i+j*len, i+j*len+len);

                Integer wordCountValue = wordCount.get(cur);
                if (wordMap.get(cur) != null && wordMap.get(cur) > 
                        (wordCountValue == null ? 0 : wordCountValue)) {

                    wordCount.put(cur, 
                            (wordCountValue == null ? 0 : wordCountValue)+1);

                    if (lastSuccessCount+1 == words.length) {
                        result.add(i);
                        break;
                    } else {
                        lastSuccessCount++;
                    }
                } else {
                    break;
                }
            }
        }
        return result;
    }
}
