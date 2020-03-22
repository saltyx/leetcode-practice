package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LetterCombinations {

    public static void main(String[] args) {
        System.out.println(new Solution().letterCombinations("23"));
        System.out.println(new Solution().letterCombinations(" "));
    }

    static class Solution {
        static HashMap<Integer, String> map = new HashMap<>();

        static {
            map.put(1, "");
            map.put(2, "abc");
            map.put(3, "def");
            map.put(4, "ghi");
            map.put(5, "jkl");
            map.put(6, "mno");
            map.put(7,"pqrs");
            map.put(8, "tuv");
            map.put(9, "wxyz");
        }

        public List<String> letterCombinations(String digits) {
            List<String> result = new ArrayList<>();
            if (digits == null || digits.length()<1) {
                return result;
            }
            for (char c : map.get(digits.charAt(0) - '0').toCharArray()) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(c);
                find(1, digits, stringBuilder, result);
            }
            return result;
        }
        //DFS
        public void find(int idx, String digits, StringBuilder sb, List<String> result) {
            if (idx >= digits.length()) {
                result.add(sb.toString());
                return;
            }
            for (char c : map.get(digits.charAt(idx) - '0').toCharArray()) {
                sb.append(c);
                find(idx+1, digits, sb, result);
                sb.deleteCharAt(sb.length()-1);
            }
        }


    }

}
