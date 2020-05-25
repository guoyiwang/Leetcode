public class _242_ValidAnagram {
//    Given two strings s and t , write a function to determine if t is an anagram of s.
//
//    For example,
//            s = "anagram", t = "nagaram", return true.
//    s = "rat", t = "car", return false.
    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;
        int[] count = new int[26];
        for(int i = 0; i < s.length(); i++){++count[s.charAt(i) - 'a'];}
        for(int i = 0; i < t.length(); i++){
            if(--count[t.charAt(i) - 'a'] < 0){
                return false;
            }
        }
        return true;
    }
}
