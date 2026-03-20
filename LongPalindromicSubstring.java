public class LongPalindromicSubstring {
    public String longestPalindrome(String s) {
        if( s == null || s.length() <= 1 ) return s;
        String result = "";
        for( int i = 0 ; i < s.length() - 1 ; i++ ) {
            String s1 = expandAroundCenter(s, i, i);
            String s2 = expandAroundCenter(s, i, i + 1);
            if ( s1.length() > result.length() ) {
                result = s1;
            }
            if ( s2.length() > result.length() ) {
                result = s2;
            }
        }
        return result;
    }

    public String expandAroundCenter(String s, int left, int right) {
        while( left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right) ) {
            left--;
            right++;
        }
        return s.substring(left + 1, right);
    }
}
