package leetcode;

import java.util.HashMap;
import java.util.Map;

public class Int2Roman {

//    Symbol       Value
//    I             1
//    V             5
//    X             10
//    L             50
//    C             100
//    D             500
//    M             1000
    public static void main(String[] args) {
        System.out.println(new Solution().intToRoman(10));
        System.out.println(new Solution().intToRoman(6));
        System.out.println(new Solution().intToRoman(4));
        System.out.println(new Solution().intToRoman(1999));
        System.out.println(new Solution().intToRoman(999));
        System.out.println(new Solution().intToRoman(2910));
    }

    static class Solution {
        static Map<Integer, String> map = new HashMap<>();

        static {
            map.put(1, "I");
            map.put(5, "V");
            map.put(10, "X");
            map.put(50, "L");
            map.put(100, "C");
            map.put(500, "D");
            map.put(1000, "M");
            map.put(4, "IV");
            map.put(9, "IX");
            map.put(40, "XL");
            map.put(90, "XC");
            map.put(400, "CD");
            map.put(900, "CM");
        }

        StringBuilder sb = new StringBuilder();
        // 1 - 3999
        public String intToRoman(int num) {

            int [] t = new int[4];

            t[0] = num/1000;
            t[1] = (num-t[0]*1000)/100;
            t[2] = (num-t[0]*1000-t[1]*100)/10;
            t[3] = (num-t[0]*1000-t[1]*100-t[2]*10);

            if (t[0] > 0) {
                append(t[0], 1000);
            }
            // 100 =< < 400
            if (t[1] > 0) {
                process(t[1], 100);
            }

            if (t[2] > 0) {
                process(t[2], 10);
            }

            if (t[3] > 0) {
                process(t[3], 1);
            }

            return sb.toString();
        }

        public void process(int base, int level) {
            if (base < 4)
                append(base, level);
            else if (base == 4)
                append(1, 4*level);
            else if (base < 9) {
                append(1, 5*level);
                append(base - 5, level);
            } else {
                append(1, 9*level);
            }
        }

        public void append(int times, int level) {
            for (int i = 0; i < times; i++) {
                sb.append(map.get(level));
            }
        }
    }
}
