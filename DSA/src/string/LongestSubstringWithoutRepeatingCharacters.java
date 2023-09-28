package string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    static public int lengthOfLongestSubstring(String s) {
        Set<Character> freq = new HashSet<>();
        int first = 0;
        int res = 0;
        for (int last = 0; last < s.length(); last++) {
            while (freq.contains(s.charAt(last)))
                freq.remove(s.charAt(first++));
            freq.add(s.charAt(last));
            res = Math.max(res, freq.size());
        }
        return res;
    }

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
