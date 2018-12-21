package jerry.wu.no3.longestSubString;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3Explanation: The answer is "abc", with the length of 3.
 */
public class LongestSubString {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int max = 0, start = 0, i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i);
            int currMax = i - start + 1;
            //第二个条件容易忽略
            if (map.containsKey(ch) && map.get(ch) >= start) {
                currMax = i - start;
                start = map.get(ch) + 1;
            }
            max = max > currMax ? max : currMax;
            map.put(ch, i);
            i++;
        }
        return max;
    }
}
