public class _392_IsSubsequence {
//    Given a string s and a string t, check if s is subsequence of t.
//
//    A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
    public boolean isSubsequence(String s, String t) {
        if(s.length() == 0) return true;
        char[] sArray = s.toCharArray();
        int sIndex = 0;
        char[] tArray = t.toCharArray();
        int tIndex = 0;
        while(tIndex < tArray.length){
            if(tArray[tIndex] == sArray[sIndex]) sIndex++;
            if(sIndex >= sArray.length) return true;
            tIndex++;
        }
        return false;
    }
}
