package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(new Solution().generateParenthesis(4));
        String[] strings = new String[]{"(((())))","((()()))","((())())","((()))()","(()(()))","(()()())","(()())()","(())(())","(())()()","()((()))","()(()())","()(())()","()()(())","()()()()"};
        List<String> result = new Solution().generateParenthesis(4);
        for (String s : strings) {
            if (!result.contains(s)) {
                System.out.println(s);
            }
        }
    }

    static class Solution {
        public List<String> generateParenthesis(int n) {
            Set<String> set = new HashSet<>();
            generate(n, n, new StringBuilder(),  set);
            return new ArrayList<>(set);
        }

        public void generate(int l, int r, StringBuilder stringBuilder, Set<String> set) {
            if (l == 0) {
                for (int i=0; i<r; ++i) {
                    stringBuilder.append(")");
                }
                set.add(stringBuilder.toString());
                stringBuilder.delete(stringBuilder.length()-r, stringBuilder.length());
                return;
            }
            stringBuilder.append("(");
            generate(l-1, r, stringBuilder, set);
            stringBuilder.deleteCharAt(stringBuilder.length()-1);
            if (l<r) {
                stringBuilder.append(")");
                generate(l ,r-1, stringBuilder, set);
                stringBuilder.deleteCharAt(stringBuilder.length()-1);
            }
        }
    }
}
