package jerry.wu.no5.longestPalindromicSubstring;

/**
 * Created by Jerry on 18/12/29.
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 */
public class LongestPalindromicSubstring {
    /**
     * 典型得动态规划得问题
     * 设 p(i, j)代表从i到j的字符组成的字符串是否是回文
     * base：
     * p(i, i) = true
     * p(i, i + 1) = true (if s[i] == s[i++])
     *
     * p[i, j] = true if (p(i+1, j- 1) = true && s[i] = s[j])
     */

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int len = s.length();
        boolean[][] dp = new boolean[len][len];
        String result = s.substring(0, 1);
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                dp[i - 1][i] = true;
                if (result.length() < 2) result = s.substring(i - 1, i + 1);
            }
        }

        // 注意，因为第一个元素要在最后检查，所以必须反着来
        for (int i = len - 2 ; i >= 0; i--) {
            for (int j = 1; j < len; j++) {
                if (!dp[i][j]) {
                    if ((i + 1) <= (j - 1) && dp[i + 1][j - 1] && (s.charAt(i) == s.charAt(j))) {
                        dp[i][j] = true;
                        if (result.length() < j - i + 1) {
                            result = s.substring(i, j + 1);
                        }
                    }
                }

            }
        }

        return result;
    }

    public static void main(String args[]) {
        String res = new LongestPalindromicSubstring().longestPalindrome("babad");
        System.out.println(res);
    }
}
